package com.challenge.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private int routingNumber;

    private String bankName;

    private static long lastTransactionId = 1;

    Map<String, BankCustomer> customers;

    public Bank(int routingNumber, String bankName) {
        this.routingNumber = routingNumber;
        this.bankName = bankName;
        this.customers = new HashMap<>();
    }

    public BankCustomer getCustomer(String customerId) {
        return customers.get(customerId);
    }

    public void addCustomer(String name, double initialCheckingDeposit, double initialSavingDeposit) {
        BankCustomer newCustomer = new BankCustomer(name, initialCheckingDeposit, initialSavingDeposit);
        customers.put(newCustomer.getCustomerId(), newCustomer);
    }

    public boolean doTransaction(String id, Type type, double amount) {
        BankAccount customerAccount = getCustomer(id).getAccount(type);
        double balance = customerAccount.getBalance();
        balance = balance + amount;
        if(balance <= 0) {
            System.err.println("Insufficient balance for the customer %s".formatted(id));
            return false;
        }
        customerAccount.setBalance(balance);
        customerAccount.commitTransaction(routingNumber, lastTransactionId++, id, amount);
        return true;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "routingNumber=" + routingNumber +
                ", bankName='" + bankName + '\'' +
                ", customers=" + customers +
                '}';
    }
}
