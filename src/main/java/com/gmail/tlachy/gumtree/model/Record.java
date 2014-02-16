package com.gmail.tlachy.gumtree.model;

import com.gmail.tlachy.gumtree.model.enums.Gender;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Record {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(("dd/MM/yy"));

    private String name;
    private Gender gender;
    private LocalDate birth;

    public Record(String name, Gender gender, LocalDate birth) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;

        Record record = (Record) o;

        if (!birth.equals(record.birth)) return false;
        if (gender != record.gender) return false;
        if (!name.equals(record.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
}
