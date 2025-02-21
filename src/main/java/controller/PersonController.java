package controller;

import model.Person;
import model.enums.Gender;
import model.enums.Region;
import persistence.PersonPersistence;

import java.time.LocalDate;
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
        List<Person> people = getAllPeople();
        if (people.isEmpty()) {
            return Arrays.asList("No person found");
        }
        Person person = people.get(index);;
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
        if(people == null){
            people = getDefaultPeople();
            savePeople();
        }
    }

    public void savePeople() {
        persistence.savePeople(people);
    }

    private ArrayList<Person> getDefaultPeople()
    {
        ArrayList<Person> defaultPeople = new ArrayList<>();

        Person lars = new Person(
                "Marty",
                "Lars",
                Gender.MALE,
                LocalDate.of(2006, 12, 27),
                "123456789",
                Region.ZENTRALSCHWEIZ,
                0
        );

        Person karl = new Person(
                "Zenker",
                "Karl",
                Gender.MALE,
                LocalDate.of(2008, 8, 22),
                "123456789",
                Region.ZENTRALSCHWEIZ,
                0
        );

        defaultPeople.add(lars);
        defaultPeople.add(karl);

        return  defaultPeople;
    }

}