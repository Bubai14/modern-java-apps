package com.learning.abstraction;

public class Fossil extends ProductForSale{
    public Fossil() {
        super.price = 79;
        super.description = "Fossil Townsman Analog Blue Dial Men's Watch-ME3110";
        super.productType = ProductType.WATCH;
    }

    @Override
    void showDetails() {
        System.out.printf("Product Type %s", super.productType.values());
        System.out.printf("Product Description %s", super.description);
        System.out.printf("Product Price %s", super.price);
    }
}
