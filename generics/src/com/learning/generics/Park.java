package com.learning.generics;

public class Park extends Point{

    String name;

    public Park(String name, double locations[]) {
        this.name = name;
        super.locations = locations;
    }

    @Override
    public void render() {
        System.out.println("Rendering:");
        System.out.printf("%s %s as %s (%5d)".formatted(this.name, LocationType.NATIONAL_PARK, "LINE", locations));
    }
}
