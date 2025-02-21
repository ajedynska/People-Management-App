package controller;

import model.Person;
import persistence.PersonPersistence;

import java.util.ArrayList;
import java.util.List;

public class PersonController {
    private ArrayList<Person> people;
    private PersonPersistence persistence;

    public PersonController(PersonPersistence persistence) {
        this.persistence = persistence;
        loadPeople();
    }

    public void setPerson(Person person) {
        people.add(person);
    }

    public void setPerson(int id, Person person) {
        if(id != -1) {

            people.set(id, person);
        }else{
            people.add(person);
        }
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