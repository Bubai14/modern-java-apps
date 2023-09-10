package com.challenge.lambda;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Lambda {

    public static void main(String[] args) {
        String sentence = "The lazy brown fox jumped over the sleeping dog";
        Arrays.asList(sentence.split(" "))
                .forEach(p ->
                        printTheParts( part -> System.out.println(part), p));

        UnaryOperator<String> everySecondCharacter = s -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                if(i % 2 == 0) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(everySecondCharacter.apply(sentence));

    }

    private static void printTheParts(Consumer<String> consumer, String part) {
        consumer.accept(part);
    }


}
