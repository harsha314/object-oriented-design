package com;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        List<String> givenList = List.of("Harsha", "Zoro", "Luffy", "Zoro", "Zoro", "Naruto", "Harsha");

        givenList.stream()
                .collect(Collectors.groupingBy(Function.identity()))
                .forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
