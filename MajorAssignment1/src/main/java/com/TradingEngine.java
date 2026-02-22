package com;

import com.TradingDb.DatabaseManager;
import com.TradingModel.Account;
import com.TradingModel.Trade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TradingEngine {
    private static ConcurrentHashMap<Integer, Account> inMemoryStore=new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Trade is being started");

        ExecutorService executorService= Executors.newFixedThreadPool(10);

        try(BufferedReader br=new BufferedReader(new FileReader("trade.csv"))){
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
    }

}
