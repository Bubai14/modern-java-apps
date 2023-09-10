package com.challenge.abstraction;

import java.util.ArrayList;
import java.util.List;

public class Store {

    static List<OrderItem> orderItems = new ArrayList<>();

    public static void main(String[] args) {
        List<ProductForSale> productForSaleList = new ArrayList<>();
        // Add products to the list
        productForSaleList.add(new iPhone15());
        productForSaleList.add(new Fossil());
        productForSaleList.add(new AcerMonitor());

        // Show product details
        showDetails(productForSaleList);


    }

    private static void showDetails(List<ProductForSale> productForSaleList) {
        for (var products : productForSaleList)
            products.showDetails();
    }

    private static void addItem(List<ProductForSale> productForSaleList, int productIndex, int quantity) {

    }
}
