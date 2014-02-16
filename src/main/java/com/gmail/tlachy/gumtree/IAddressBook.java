package com.gmail.tlachy.gumtree;

import com.gmail.tlachy.gumtree.model.Record;
import com.gmail.tlachy.gumtree.model.enums.Gender;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;



public interface IAddressBook {

    public static final String CSV_SEPARATOR = ",";

    List<Record> getRecords();

    List<Record> getRecords(Comparator<Record> comparator);

    List<Record> getRecords(Predicate<Record> predicate);

    List<Record> getRecords(Predicate<Record> predicate, Comparator<Record> comparator);

    int getDiffInDaysBetweenBirths(Record r1, Record r2);

    default Function<String, Record> mapToRecord() {
        return
                (line) -> {
                    String[] p = line.split(CSV_SEPARATOR);

                    return new Record(p[0].trim(),
                            Gender.valueOf(p[1].trim()),
                            LocalDate.parse(p[2].trim(), Record.DATE_TIME_FORMATTER));
                };
    }

}
