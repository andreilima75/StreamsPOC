package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamsPOC {

    static void main() {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, "Female"),
                new Person("Bob", 30, "Male"),
                new Person("Charlie", 17, "Male"),
                new Person("Diana", 35, "Female"),
                new Person("Eve", 22, "Female")
        );

        System.out.println("=== Pessoas originais ===");
        people.forEach(System.out::println);

        Predicate<Person> isAdult = p -> p.getAge() >= 18;


        System.out.println("=== 1. Filter: Adultos ===");

        List<Person> adults = people.stream()
                .filter(isAdult)
                .toList();

        adults.forEach(System.out::println);
    }
}
