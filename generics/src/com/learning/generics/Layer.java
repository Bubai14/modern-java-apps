package com.learning.generics;

import java.util.List;

public class Layer<T extends Mappable> {

    private List<T> elements;

    public Layer(List<T> elements) {
        this.elements = elements;
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public void renderLayer() {
        for (var e : elements ) {
            e.render();
        }
    }
}
