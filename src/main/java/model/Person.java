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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender.toString();
    }

    public boolean isMale(){
        return gender == Gender.MALE;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setIsMale(boolean isMale) {
        this.gender = isMale ? Gender.MALE : Gender.FEMALE;
    }

    public String getDateOfBirth() {
        return LocalDateConverter.convertDateToString(dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirthStr) {
        this.dateOfBirth = LocalDateConverter.convertStringToDate(dateOfBirthStr);
    }

    public String getAhvNumber() {
        return ahvNumber;
    }

    public void setAhvNumber(String ahvNumber) {
        this.ahvNumber = ahvNumber;
    }

    public String getRegion() {
        return region.toString();
    }

    public void setRegion(String regionStr) {
        this.region = Region.fromString(regionStr);
    }

    public String getChildren() {
        return Integer.toString(children);
    }

    public void setChildren(String children) {
        this.children = Integer.parseInt(children);
    }
}