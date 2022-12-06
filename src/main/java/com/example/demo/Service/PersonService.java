package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Person;

@Service
public class PersonService {
    private List<Person> persons = new ArrayList<>();

    public PersonService() {
        persons.add(new Person("Kaung", 20));
        persons.add(new Person("Jason", 20));
        persons.add(new Person("Yunz", 20));
    }

    // Read
    public List<Person> getPerson() {
        return persons;
    }

    // Create
    public Person addPerson(Person newPerson) {
        persons.add(new Person(newPerson.getId(), newPerson.getName(), newPerson.getAge()));
        return newPerson;
    }

    // DELETE
    public Person removePerson(Person person) {
        Person found = persons.stream().filter(p -> p.getId().equals(person.getId())).findAny().orElse(null);
        persons.remove(found);
        return found;
    }

    // Update
    public Person updatePerson(Person person) {
        Person found = persons.stream().filter(p -> p.getId().equals(person.getId())).findAny().orElse(null);

        Person update = new Person();
        update.setId(person.getId());
        update.setName(person.getName());
        update.setAge(person.getAge());
        persons.remove(found);
        persons.add(update);
        return update;
    }

    

}
