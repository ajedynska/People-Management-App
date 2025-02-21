package persistence;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import model.Person;
import model.enums.Gender;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonPersistence {
    private final String filename = "people.json";
    private ObjectMapper mapper;

    public PersonPersistence() {
        mapper = new ObjectMapper();

        // Create a module to handle custom deserialization
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Gender.class, new JsonDeserializer<Gender>() {
            @Override
            public Gender deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                String value = p.getValueAsString();
                Gender gender = Gender.fromString(value);
                if (gender == null) {
                    throw new IllegalArgumentException("Invalid gender: " + value);
                }
                return gender;
            }
        });

        mapper.registerModule(module);
    }

    public ArrayList<Person> loadPeople() {
        ArrayList<Person> people = null;
        try {
            File jsonFile = new File(filename);

            if (jsonFile.exists()) {
                people = new ArrayList<>();
                people.addAll(List.of(mapper.readValue(jsonFile, Person[].class)));
            }else{
                jsonFile.createNewFile(); // and return null
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

    public void savePeople(ArrayList<Person> people) {
        try {
            File jsonFile = new File(filename);
            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, people);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
