package com.challenge.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        ArrayList<String> groceries = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            printActions();
            switch (Integer.parseInt(scanner.nextLine())) {
                case 0 -> {
                    System.out.println("Thank you. Good Bye!!!");
                    flag = false;
                }
                case 1 -> {
                    System.out.println("Add items [separate items by comma]");
                    String[] newItems = scanner.nextLine().split(",");
                    // Check for duplicates
                    for (String i : newItems) {
                        String trimmedItem = i.trim();
                        if (!groceries.contains(trimmedItem)) {
                            groceries.add(trimmedItem);
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Add items to be removed [separate items by comma]");
                    String[] newItems = scanner.nextLine().split(",");
                    for (String i : newItems) {
                        String trimmedItem = i.trim();
                        groceries.remove(trimmedItem);
                    }
                }
                default -> flag = false;
            }
            groceries.sort(Comparator.naturalOrder());
            if(groceries.isEmpty())
                System.out.println("No groceries in your list!!");
            else
                System.out.println("Grocery List:"+ groceries);
        }
    }

    private static void printActions() {
        String actionText = """
                Available actions:
                0 - to shutdown
                1 - to add item(s) to the list (comma delimited list)
                2 - to remove any items from the list (comma delimited list)
                Enter a number for which action you want to do:
                """;
        System.out.println(actionText);
    }
}
