package com.challenge.list;

import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions) {

    public Customer(String name, double initialDeposit) {
        this(name.toUpperCase(),
                new ArrayList<Double>(500));
        transactions.add(initialDeposit);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}

public class Transactor {

    public static void main(String[] args) {
        Bank hdfc = new Bank("HDFC Bank");
        hdfc.addCustomer("Bubai Bal", 500);
        hdfc.addCustomer("Soma Bal", 3500);
        hdfc.transact("Bubai Bal", "Soma Bal", 500);
        hdfc.printStatements("Soma Bal");
        hdfc.printStatements("Bubai Bal");
    }
}

class Bank {
    String name;
    ArrayList<Customer> customers = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public void addCustomer(String name, double initialDeposit) {
        if(getCustomer(name) == null) {
            customers.add(new Customer(name, initialDeposit));
            System.out.println(String.format("Customer %s added successfully!", name));
        }
    }

    public Customer getCustomer(String name) {
        for(var customer: customers) {
            if(customer.name().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        System.out.println(String.format("Customer %s was not found", name));
        return null;
    }

    public void printStatements(String name) {
        Customer customer = getCustomer(name);
        if(customer != null) {
            System.out.println("Bank name: "+ this.name);
            System.out.println(customer);
        }
    }

    public boolean transact(String fromCustomerName, String toCustomerName, double amount) {
        Customer fromCustomer = getCustomer(fromCustomerName);
        Customer toCustomer = getCustomer(toCustomerName);
        if(null != fromCustomer && null != toCustomer) {
            fromCustomer.transactions().add(amount * -1);
            toCustomer.transactions().add(amount);
            System.out.println("Transaction Successful!!!");
            return true;
        }
        return false;
    }
}