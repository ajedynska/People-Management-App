package persistence;

import bwz.models.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersistenceService {
    private String filename = "employees.json";
    private ObjectMapper mapper;

    public PersistenceService() {
        mapper = new ObjectMapper();
    }

    public List<Employee> readEmployee() {
        List<Employee> employees = new ArrayList<>();

        try{
            File jsonFile = new File(filename);
            if(jsonFile.exists()){
                employees = Arrays.stream(mapper.readValue(jsonFile, Employee[].class)).toList();
            }

        }catch(IOException e){
            e.printStackTrace();
        }

        return employees;
    }

    public void saveEmployee(List<Employee> employees) {
        try{
            File jsonFile = new File(filename);
            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, employees);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
