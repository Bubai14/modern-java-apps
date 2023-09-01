package com.learning.generics;

public class River extends Line{

    String name;

    public River(String name, double[][] locations) {
        this.name = name;
        super.locations = locations;
    }

    @Override
    public void render() {
        System.out.println("Rendering:");
        System.out.printf("%s %s as %s (%5d)".formatted(this.name, LocationType.RIVER, "POINT", locations));
    }
}
