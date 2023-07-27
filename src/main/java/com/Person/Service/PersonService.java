package com.Person.Service;

import com.Person.Entity.Person;

import java.util.List;

public interface PersonService {
    Person savePerson(Person person);
    Person updatePerson(Long id, Person person);
    void deletePerson(Long id);
    Person getPersonById(Long id);
    List<Person> getAllPersons();
}
