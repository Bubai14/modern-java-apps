package com.learning.interfaceable;

enum GeometryType { POINT, LINE, POLYGON }

enum Color { BLACK, BLUE, GREEN, ORANGE, RED }

enum Marker { CIRCLE, PUSH_PIN, SQUARE, TRIANGLE, STAR }

enum LineMarker {DASHED, DOTTED, SOLID}

public interface Mappable {

    String JSON_PROPERTY = """
    properties: {%s}
    """;

    String getLabel();

    GeometryType getGeometryType();

    String getIconType();

    default String toJSON() {
         return """
               "type": "%s", "label": "%s", "marker": "%s"
               """.formatted(getGeometryType(), getLabel(), getIconType());
    }

    static void printProperties(Mappable mappable) {
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
}
