package controller;

import model.Person;
import persistence.PersonPersistence;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void setPerson(int index, Person person) throws IndexOutOfBoundsException {
        if(index != 0) {
            people.set(index, person);
        }else{
            people.add(person);
        }
    }

    public Person getPerson(int index) throws IndexOutOfBoundsException {
        return people.get(index);
    }

    public List<String> getPersonAttributes(int index) throws IndexOutOfBoundsException {
        Person person = people.get(index);
        return Arrays.asList(
                person.getLastName(),
                person.getFirstName(),
                person.getGender(),
                person.getDateOfBirth(),
                person.getAhvNumber(),
                person.getRegion(),
                person.getChildren()
        );
    }

    public void updatePerson(int index, Person person) throws IndexOutOfBoundsException {
        people.set(index, person);
        savePeople();
    }

    public void deletePerson(int index) throws IndexOutOfBoundsException {
        people.remove(index);
        savePeople();
    }

    public ArrayList<Person> getAllPeople() {
        return people;
    }

    public void loadPeople() {
        people = persistence.loadPeople();
    }

    public void savePeople() {
        persistence.savePeople(people);
    }

}