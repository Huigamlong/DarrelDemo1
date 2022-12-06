package com.example.demo.Model;

import java.util.UUID;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Person {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int age;

    public Person(String name, int age) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.name = name;
        this.age = age;
    }

    public Person(String Id, String name, int age) {
        this.id = Id;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    
}
