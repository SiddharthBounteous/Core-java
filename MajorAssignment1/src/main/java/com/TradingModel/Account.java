package com.TradingModel;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private int accountId;

    //{symbol->quantity}
    private ConcurrentHashMap<String, AtomicInteger>positions;

    //to store history of all trades by a particular user
    private CopyOnWriteArrayList<Trade>trades;

    public Account(int accountId) {
        this.accountId = accountId;
        this.positions = new ConcurrentHashMap<>();
        this.trades = new CopyOnWriteArrayList<>();
    }

    public int getAccountId() {
        return accountId;
    }

    public ConcurrentHashMap<String, AtomicInteger> getPositions() {
        return positions;
    }

    public CopyOnWriteArrayList<Trade> getTrades() {
        return trades;
    }
}
