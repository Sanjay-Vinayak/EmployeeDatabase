package com.Person.Service.impl;

// PersonServiceImpl.java
import com.Person.Entity.Person;
import com.Person.Repository.PersonRepository;
import com.Person.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        Person existingPerson = getPersonById(id);
        if (existingPerson != null) {
            person.setId(id);
            return personRepository.save(person);
        }
        return null; // or throw NotFoundException
    }

    @Override
    public void deletePerson(Long id) {
        Person existingPerson = getPersonById(id);
        if (existingPerson != null) {
            personRepository.delete(existingPerson);
        }
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}

