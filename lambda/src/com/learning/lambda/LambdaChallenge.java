package com.learning.lambda;

import java.util.*;

public class LambdaChallenge {

    static Random random = new Random();

    public static void main(String[] args) {
        String[] firstNames = {"Bob", "Charlie", "Aniket", "Rudra", "Marylyn", "Anna"};
        System.out.println(Arrays.toString(firstNames));
        Arrays.setAll(firstNames, i -> firstNames[i].toUpperCase(Locale.ROOT));
        System.out.println(Arrays.toString(firstNames));

        List<String> firstNameList = Arrays.asList(firstNames); // List backed by an array, changes the array for any changes in the list.
        //firstNameList.replaceAll(s -> s+" "+generateRandomMiddleInitial('A', 'D')+".");
        System.out.println(Arrays.toString(firstNames));

        firstNameList.replaceAll(s -> reverseName(s));
        System.out.println(Arrays.toString(firstNames));

    }

    private static char generateRandomMiddleInitial(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String reverseName(String name) {
        return new StringBuilder(name).reverse().toString();
    }
}
