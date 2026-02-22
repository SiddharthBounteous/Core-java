package com;

import com.TradingDb.DatabaseManager;
import com.TradingModel.Account;
import com.TradingModel.Trade;
import org.postgresql.jdbc.PgConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TradingEngine {
    private static ConcurrentHashMap<Integer, Account> inMemoryStore=new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Trade is being started");

        ExecutorService executorService= Executors.newFixedThreadPool(10);

        try(BufferedReader br=new BufferedReader(new FileReader("trades.csv"))){
            String line;
            boolean firstLine=true;

            //skip header
            while((line=br.readLine())!=null){
                if(firstLine){
                    firstLine=false;
                    continue;
                }

                String[] data=line.split(",");
                int tradeId=Integer.parseInt(data[0]);
                int accountId=Integer.parseInt(data[1]);
                String symbol=data[2];
                int quantity=Integer.parseInt(data[3]);
                double price=Double.parseDouble(data[4]);
                String side=data[5];
                LocalDateTime timestamp=LocalDateTime.parse(data[6]);

                //negative check
                if(quantity<0){
                    System.err.println("Negative quantity "+quantity+" found. Skipping it!!!");
                    continue;
                }

                //everything is correct, creating trade object now
                Trade trade=new Trade(tradeId,accountId,symbol,quantity,price,side,timestamp);

                //sending it to thread for managing it
                executorService.submit(()->processTrade(trade));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            executorService.awaitTermination(1, TimeUnit.MINUTES);
            System.out.println("All trades processed successfully.\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        generateReports();

        DatabaseManager.closePool();
    }

    private static void processTrade(Trade trade){
        //get the account from memory and if its new account, create it
        Account account=inMemoryStore.computeIfAbsent(trade.getAccountId(),Account::new);

        //add trade to history
        account.getTrades().add(trade);

        //calculating each trade based on buy/sell
        String side=trade.getSide();
        int quantityChange;
        if(side.equals("BUY")){
            quantityChange=trade.getQuantity();
        }
        else{
            quantityChange=-trade.getQuantity();
        }

        //if not particular stock is not traded before add it otherwise give current total for it
        AtomicInteger position=account.getPositions().computeIfAbsent(trade.getSymbol(),k->new AtomicInteger(0));

        int newTotalQuantity=position.addAndGet(quantityChange);

        try(Connection conn=DatabaseManager.getConnection()){
            //Ensure Account exists in the DB
            String insertAccountSql="INSERT INTO account (account_id) VALUES (?) ON CONFLICT DO NOTHING";

            try(PreparedStatement ps = conn.prepareStatement(insertAccountSql)){
                ps.setInt(1, trade.getAccountId());
                ps.executeUpdate();
            }

            //saving to trade table
            String insertTrade="INSERT INTO trade (trade_id, account_id, symbol, quantity, price, side, trade_timestamp) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try(PreparedStatement ps = conn.prepareStatement(insertTrade)){
                ps.setInt(1, trade.getTradeId());
                ps.setInt(2, trade.getAccountId());
                ps.setString(3, trade.getSymbol());
                ps.setInt(4, trade.getQuantity());
                ps.setDouble(5, trade.getPrice());
                ps.setString(6, trade.getSide());
                ps.setTimestamp(7, Timestamp.valueOf(trade.getTimestamp()));
                ps.executeUpdate();
            }

            //updating position table
            String upsertPosition="INSERT INTO position (account_id, symbol, total_quantity) VALUES (?, ?, ?) " +
                    "ON CONFLICT (account_id, symbol) DO UPDATE SET total_quantity = EXCLUDED.total_quantity";
            try(PreparedStatement ps = conn.prepareStatement(upsertPosition)){
                ps.setInt(1, trade.getAccountId());
                ps.setString(2, trade.getSymbol());
                ps.setInt(3, newTotalQuantity);
                ps.executeUpdate();
            }
        }
        catch (Exception e){
            System.err.println("Database error processing Trade " + trade.getTradeId() + ": " + e.getMessage());
        }
    }


    private static void generateReports(){
        System.out.println("========================================");
        System.out.println("          LEADERBOARD REPORTS           ");
        System.out.println("========================================\n");

        //group trades by user
        System.out.println("--- Trades Grouped By User ---");
        inMemoryStore.forEach((accountId, account)->{
            System.out.println("User ID: " + accountId + " -> Total Trades Made: " + account.getTrades().size());
        });
        System.out.println();

        //total money involved per stock
        System.out.println("--- Total exposure per stock ---");
        Map<String,Double> exposurePerSymbol=inMemoryStore.values().stream()
                .flatMap(account->account.getTrades().stream())
                .collect(Collectors.groupingBy(Trade::getSymbol,Collectors.summingDouble(trade->trade.getQuantity()*trade.getPrice())));

        exposurePerSymbol.forEach((symbol,exposure) ->
                System.out.printf("Symbol: %-5s | Total Exposure: %,.2f\n", symbol, exposure)
        );
        System.out.println();

        //Find Top 5 users by portfolio value
        System.out.println("--- Top 5 Users By Portfolio Volume ---");
        inMemoryStore.values().stream()
                .sorted((a1,a2)->Double.compare(calculateVolume(a2), calculateVolume(a1))) // Sort descending
                .limit(5)
                .forEach(account->{
                    System.out.printf("User ID: %d | Total Traded Volume: $%,.2f\n",
                            account.getAccountId(), calculateVolume(account));
                });
        System.out.println("========================================");
    }

    private static double calculateVolume(Account account) {
        return account.getTrades().stream()
                .mapToDouble(trade->trade.getQuantity()*trade.getPrice())
                .sum();
    }
}
