package com.TradingModel;

import java.time.LocalDateTime;

public class Trade {
    private int tradeId;
    private int accountId;
    private String symbol;
    private int quantity;
    private double price;
    private String side;
    private LocalDateTime timestamp;

    public Trade(int tradeId, int accountId, String symbol, int quantity, double price, String side, LocalDateTime timestamp) {
        this.tradeId = tradeId;
        this.accountId = accountId;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
        this.timestamp = timestamp;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getTradeId() {
        return tradeId;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getSide() {
        return side;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
