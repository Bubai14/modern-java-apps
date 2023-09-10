package com.challenge.interfaceable;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static void main(String[] args) {

        List<Mappable> mappables = new ArrayList<>();
        mappables.add(new Building("Pragati Maidan", UsageType.GOVERNMENT));
        mappables.add(new Building("Eden Gardens", UsageType.SPORTS));
        mappables.add(new Building("Merlin X", UsageType.RESIDENTIAL));

        for(var mappable : mappables) {
            Mappable.printProperties(mappable);
        }
    }
}
