package com.challenge.abstraction;

public class iPhone15 extends ProductForSale{

    public iPhone15() {
        super.price = 499;
        super.description = "Apple iPhone 15 (128 GB) - Blue";
        super.productType = ProductType.MOBILE;
    }

    @Override
    void showDetails() {
        System.out.printf("Product Type %s\n", super.productType.values());
        System.out.printf("Product Description %s\n", super.description);
        System.out.printf("Product Price %s\n", super.price);
    }
}
