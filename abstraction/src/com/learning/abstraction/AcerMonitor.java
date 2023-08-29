package com.learning.abstraction;

public class AcerMonitor extends ProductForSale{

    public AcerMonitor() {
        super.price = 125;
        super.description = "Acer DA430 43 Inch Smart Full HD IPS Panel LCD Monitor with LED Backlight";
        super.productType = ProductType.MONITOR;
    }

    @Override
    void showDetails() {
        System.out.printf("Product Type %s", super.productType.values());
        System.out.printf("Product Description %s", super.description);
        System.out.printf("Product Price %s", super.price);
    }
}
