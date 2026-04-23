package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Person {
    private String name;
    private int age;
    private String gender;
}
