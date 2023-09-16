package com.challenge.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

enum Type {CHECKING, SAVING, CURRENT}

public class BankAccount {

    private final Type type;

    private final long accountNumber = generateAccountNumber();

    private double balance;

    Map<Long, Transaction> transactions;

    public BankAccount(Type type) {
        this(type, 1000);
    }

    public BankAccount(Type type, double balance) {
        this.type = type;
        this.balance = balance;
        this.transactions = new HashMap<>();
    }

    private long generateAccountNumber() {
        return (long) new Random().nextLong();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Map<Long, Transaction> getTransactions() {
        return Map.copyOf(transactions);
    }

    public Type type() {
        return type;
    }

    public void commitTransaction(int routingNumber, long transactionId, String customerId, double amount) {
        transactions.put(transactionId, new Transaction(routingNumber, customerId, transactionId, amount));
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "type=" + type +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
