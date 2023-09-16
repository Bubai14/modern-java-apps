package com.challenge.bank;

import java.util.Arrays;
import java.util.List;

public class BankCustomer {

    private final String customerId;

    private final String customerName;

    private final List<BankAccount> accounts;

    BankCustomer(String customerName, List<BankAccount> accounts) {
        this.customerName = customerName;
        this.accounts = accounts;
        this.customerId = customerName.substring(0, 1) + Math.floor(Math.random() *(8 - 3 + 1) + 3);
    }

    BankCustomer(String customerName, double checkingAmount, double savingsAmount) {
        this.customerName = customerName;
        this.accounts = Arrays.asList(new BankAccount(Type.CHECKING, checkingAmount), new BankAccount(Type.SAVING, savingsAmount));
        this.customerId = customerName.substring(0, 1) + Math.floor(Math.random() *(8 - 3 + 1) + 3);
    }

    public List<BankAccount> accounts() {
        // Return an unmodifiable list
        return List.copyOf(accounts);
    }

    public String customerName() {
        return customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BankAccount getAccount(Type type) {
        for(BankAccount account : accounts) {
            if (account.type().equals(type)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "BankCustomer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
