package model;

import model.enums.Gender;
import model.enums.Region;

import java.time.LocalDate;

public class Person{
    private String lastName;
    private String firstName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String AhvNumber;
    private Region region;
    private int children;
}