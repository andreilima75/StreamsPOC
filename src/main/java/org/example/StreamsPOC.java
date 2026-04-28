package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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


        System.out.println("=== Filter: Adultos ===");

        List<Person> adults = people.stream()
                .filter(isAdult)
                .toList();

        adults.forEach(System.out::println);

        Predicate<Person> isFemale = p -> "Female".equals(p.getGender());
        Predicate<Person> adultFemale = isAdult.and(isFemale);

        System.out.println("=== Filter + Map: Nome das adultas em maiúsculo ===");
        List<String> adultFemaleNames = people.stream()
                .filter(adultFemale)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(adultFemaleNames);

        Predicate<Person> nameStartsWithA = p -> p.getName().startsWith("A");

        System.out.println("=== Filter com Predicate inline + Map ===");
        List<String> namesStartingWithA = people.stream()
                .filter(nameStartsWithA)
                .map(p -> p.getName() + " (" + p.getAge() + ")")
                .collect(Collectors.toList());
        System.out.println(namesStartingWithA);


        System.out.println("=== Arrays ===");
        String[] namesArray = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        List<String> longNames = Arrays.stream(namesArray)
                .filter(s -> s.length() > 4)
                .map(String::toUpperCase)
                .toList();

        System.out.println("Nomes com mais de 4 letras (maiúsculo): " + longNames);
    }


}
