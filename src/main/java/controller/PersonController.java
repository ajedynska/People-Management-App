package controller;

import model.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonController {
    private List<Person> people = new ArrayList<>();


    public PersonController(List<Person> people) {
        this.people = people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public Person getPerson(int index) {
        return people.get(index);
    }

    public void updatePerson(int index, Person person) {
        people.set(index, person);
        savePeople();
    }

    public void deletePerson(int index) {
        people.remove(index);
        savePeople();
    }

    public List<Person> getAllPeople() {
        return people;
    }

    public void loadPeople() {
        // Load people from file
    }

    public void savePeople() {
        // Save people to file
    }

}