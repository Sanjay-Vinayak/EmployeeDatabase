package com.Person.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private int age;
}
