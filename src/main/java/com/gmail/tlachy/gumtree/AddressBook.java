package com.gmail.tlachy.gumtree;

import com.gmail.tlachy.gumtree.model.Record;
import com.gmail.tlachy.gumtree.model.enums.Gender;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;



public class AddressBook implements IAddressBook {

    public static final String CSV_SEPARATOR = ",";
    private final List<Record> records;


    public AddressBook() {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("address_book.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        records = br.lines()
                .map(mapToRecord)
                .collect(Collectors.toList());
    }


    @Override
    public List<Record> getRecords() {
        return records;
    }






    private static Function<String, Record> mapToRecord = (line) -> {
        String[] p = line.split(CSV_SEPARATOR);

        return new Record(p[0].trim(),
                Gender.valueOf(p[1].trim()),
                LocalDate.parse(p[2].trim(), Record.DATE_TIME_FORMATTER));
    };
}
