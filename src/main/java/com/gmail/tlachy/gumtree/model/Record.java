package com.gmail.tlachy.gumtree.model;

import com.gmail.tlachy.gumtree.model.enums.Gender;
import java.time.LocalDate;


/**
 * Created by tlachac on 2/16/14.
 */
public class Record {

    private String name;
    private Gender gender;
    private LocalDate birth;

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
