package com.TradingModel;

public class Position {
    private String symbol;
    private int totalQuantity;

    public Position(String symbol, int totalQuantity) {
        this.symbol = symbol;
        this.totalQuantity = totalQuantity;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
