package com.challenge.abstraction;

public abstract class ProductForSale {

    double price;
    String description;
    ProductType productType;

    double salesPrice(int quantity) {
        return quantity * this.price;
    }

    void printPricedLineItem(int quantity) {
        System.out.printf("Product - %s | Quantity - %d | Price - %10.2f",
                this.getClass().getSimpleName(), quantity, salesPrice(quantity));
    }

    abstract void showDetails();
}
