package model.enums;

public enum Gender {
    MALE ("Mann"),
    FEMALE ("Frau");

    private final String nameGerman;

    Gender(String nameGerman) {
        this.nameGerman = nameGerman;
    }

    public String toString() {
        return nameGerman;
    }

    public static Gender fromString(String nameGerman) {
        for(Gender gender : Gender.values()) {
            if(gender.toString().equals(nameGerman)) {
                return gender;
            }
        }

        return null;
    }
}
