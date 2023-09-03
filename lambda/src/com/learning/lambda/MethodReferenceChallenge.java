package com.learning.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

import static com.learning.lambda.LambdaChallenge.random;

public class MethodReferenceChallenge {

    public static void main(String[] args) {
        String[] names = {"Bob", "Charlie", "Aniket", "Rudra", "Marylyn", "Anna"};
        List<String> nameList = Arrays.asList(names);

        UnaryOperator<String> toUpper = String::toUpperCase;
        UnaryOperator<String> middleInitial = s -> s+" "+generateRandomMiddleInitial('A', 'D');
        UnaryOperator<String> reversedLastName = s -> s + " " + reverseName(s);

        nameList.replaceAll(toUpper::apply);
        nameList.replaceAll(middleInitial::apply);
        nameList.replaceAll(reversedLastName::apply);

        System.out.println(Arrays.toString(names));
    }

    private static char generateRandomMiddleInitial(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String reverseName(String name) {
        return new StringBuilder(name.substring(0, name.indexOf(' '))).reverse().toString();
    }
}
