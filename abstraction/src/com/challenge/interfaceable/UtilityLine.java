package com.challenge.interfaceable;

public class UtilityLine implements Mappable{
    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public GeometryType getGeometryType() {
        return GeometryType.LINE;
    }

    @Override
    public String getIconType() {
        return null;
    }
}
