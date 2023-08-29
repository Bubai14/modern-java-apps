package com.learning.list;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

record Place(String name, int distance) {

    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance);
    }
}

public class LinkedLists {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();
        // Populate the list
        inflateList(placesToVisit);
        //System.out.println(placesToVisit);
        printActions();
        boolean quitLoop = false;
        boolean forward = true;
        var iterator = placesToVisit.listIterator();

        while(!quitLoop) {
            System.out.println("Enter the value:");
            String action = scanner.nextLine().toUpperCase(Locale.ROOT).substring(0, 1);
            if(!iterator.hasPrevious()) {
                System.out.println("Originating place:"+iterator.next());
                forward = true;
            }
            if(!iterator.hasNext()) {
                System.out.println("End place:"+iterator.previous());
                forward = false;
            }

            switch (action) {
                case "F" -> {
                    System.out.println("User wants to go forward");
                    if(!forward) {
                        forward = true;
                        if(iterator.hasNext()) {
                            iterator.next();
                        }
                    }
                    if(iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                }
                case "B" -> {
                    System.out.println("User wants to go backward");
                    if(forward) {
                        forward = false;
                        if(iterator.hasPrevious()) {
                            iterator.previous();
                        }
                    }
                    if(iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    }
                }
                case "L" -> System.out.println(placesToVisit);
                case "M" -> printActions();
                default -> quitLoop = true;
            }
        }
    }


    private static void inflateList(LinkedList<Place> placesToVisit) {
        Place place0 = new Place("Sydney", 0);
        addPlacesToVisit(placesToVisit, place0);
        Place place1 = new Place("Adelaide", 1374);
        addPlacesToVisit(placesToVisit, place1);
        Place place2 = new Place("Alice Springs", 2771);
        addPlacesToVisit(placesToVisit, place2);
        Place place3 = new Place("Brisbane", 917);
        addPlacesToVisit(placesToVisit, place3);
        Place place4 = new Place("Darwin", 3972);
        addPlacesToVisit(placesToVisit, place4);
        Place place5 = new Place("Melbourne", 877);
        addPlacesToVisit(placesToVisit, place5);
    }

    private static void addPlacesToVisit(LinkedList<Place> placesToVisit, Place placeToVisit) {
        for(Place place : placesToVisit) {
            if(place.name().equalsIgnoreCase(placeToVisit.name())) {
                System.out.println("Found Duplicate");
                return;
            }
        }
        // Sort the list by distance
        int matchedIndex = 0;
        for(var place : placesToVisit) {
            if(placeToVisit.distance() < place.distance()){
                placesToVisit.add(matchedIndex, placeToVisit);
                return;
            }
            matchedIndex++;
        }
        placesToVisit.add(placeToVisit);
    }

    private static void printActions() {
        String actionText = """
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """;
        System.out.println(actionText);
    }
}
