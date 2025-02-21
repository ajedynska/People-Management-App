package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Person;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonPersistence {
    private final String filename = "people.json";
    private ObjectMapper mapper;

    public PersonPersistence() {
        mapper = new ObjectMapper();
    }

    public List<Person> loadPeople() {
        List<Person> people = new ArrayList<Person>();
        try {
            File jsonFile = new File(filename);

            if (jsonFile.exists()) {
                Person[] personArray = mapper.readValue(jsonFile, Person[].class);
                for (Person person : personArray) {
                    people.add(person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

    public void savePeople(List<Person> people) {
        try {
            File jsonFile = new File(filename);
            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, people);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
