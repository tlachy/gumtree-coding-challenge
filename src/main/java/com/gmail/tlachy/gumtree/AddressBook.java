package com.gmail.tlachy.gumtree;

import com.gmail.tlachy.gumtree.model.Record;
import com.gmail.tlachy.gumtree.model.enums.Gender;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class AddressBook implements IAddressBook {

    private final List<Record> records;


    public AddressBook() {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("address_book.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        records = br.lines()
                .map(mapToRecord())
                .collect(Collectors.toList());
    }


    @Override
    public List<Record> getRecords() {
        return records;
    }

    @Override
    public List<Record> getRecords(Predicate<Record> predicate, Comparator<Record> comparator) {
        return records.stream().filter(predicate).sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public List<Record> getRecords(Comparator<Record> comparator) {
        return records.stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public List<Record> getRecords(Predicate<Record> predicate) {
        return records.stream().filter(predicate).collect(Collectors.toList());
    }

}
