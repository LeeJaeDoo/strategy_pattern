package com.company;

//import com.company.chain.HeaderTextProcessing;
//import com.company.chain.ProcessingObject;
//import com.company.chain.SpellCheckerProcessing;
import com.company.observer.Feed;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
//        Validator numericValidator = new Validator(new IsNumeric());
        /*Validator numericValidator = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b1 = numericValidator.validate("aaaa");
        System.out.println(b1);

//        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        Validator lowerCaseValidator = new Validator((String s) -> s.matches("\\d+"));
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println(b2);*/

        /*Feed f = new Feed();
        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking new in NY! " + tweet);
            }
        });
        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        });
        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        });

        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");*/

        UnaryOperator<String> headerTextProcessing = (String input) -> "From Raoul, Mario and Alan: " + input;
        UnaryOperator<String> spellCheckerProcessing = (String input) -> input.replaceAll("labda", "lambda");

        Function<String, String> pipeline = headerTextProcessing.andThen(spellCheckerProcessing);

        String result = pipeline.apply("Aren't labdas really sexy?!!!");
        System.out.println(result);
    }
}
