package model;

import model.enums.Gender;
import model.enums.Region;

import java.time.LocalDate;

public class Person{
    private String lastName;
    private String firstName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String ahvNumber;
    private Region region;
    private int children;

    public Person(String lastName, String firstName, Gender gender, LocalDate dateOfBirth,
                  String ahvNumber, Region region, int children) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.ahvNumber = ahvNumber;
        this.region = region;
        this.children = children;
    }

    @Override
    public String toString(){
        return lastName + " " + firstName;
    }
}