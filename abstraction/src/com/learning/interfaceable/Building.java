package com.learning.interfaceable;

enum UsageType { ENTERTAINMENT, GOVERNMENT, RESIDENTIAL, SPORTS }

public class Building implements Mappable{

    String name;
    UsageType usageType;

    public Building(String name, UsageType usageType) {
        this.name = name;
        this.usageType = usageType;
    }

    @Override
    public String getLabel() {
        return name + "(" + usageType + ")";
    }

    @Override
    public GeometryType getGeometryType() {
        return GeometryType.POINT;
    }

    @Override
    public String getIconType() {
        return switch (usageType){
            case ENTERTAINMENT -> Color.GREEN + " " + Marker.TRIANGLE;
            case GOVERNMENT -> Color.RED + " " + Marker.STAR;
            case RESIDENTIAL -> Color.BLUE + " " + Marker.SQUARE;
            default -> Color.ORANGE + " " + Marker.CIRCLE;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s", "usage": "%s"
                """.formatted(this.name, this.usageType);
    }
}
