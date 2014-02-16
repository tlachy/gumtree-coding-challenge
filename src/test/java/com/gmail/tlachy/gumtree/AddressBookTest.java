package com.gmail.tlachy.gumtree;

import com.gmail.tlachy.gumtree.model.enums.Gender;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link com.gmail.tlachy.gumtree.AddressBook}.
 *
 * @author tlachy@gmail.com
 */
@RunWith(JUnit4.class)
public class AddressBookTest {


    @Test
    public void testLoad() {
        IAddressBook addressBook = new AddressBook();

        assertEquals("5 records should be loaded",
                addressBook.getRecords().size(),
                5);
    }


    @Test
    public void testHowManyMales() {
        IAddressBook addressBook = new AddressBook();

        assertEquals("There should be 3 males",
                addressBook.getRecords(r -> r.getGender().equals(Gender.Male)).size(),
                3);
    }

    @Test
    public void testHowIsOldest() {
        IAddressBook addressBook = new AddressBook();

        assertEquals(
                addressBook.getRecords((r1, r2) -> r1.getBirth().compareTo(r2.getBirth())).get(0),
                addressBook.mapToRecord().apply("Wes Jackson, Male, 14/08/74"));

    }


    @Test
    public void testHowManyMalesAndHowIsOldestAtOnce() {
        IAddressBook addressBook = new AddressBook();

        assertEquals("There should be 3 males",
                addressBook.getRecords(r -> r.getGender().equals(Gender.Male)).size(),
                3);

        assertEquals(
                addressBook.getRecords((r1, r2) -> r1.getBirth().compareTo(r2.getBirth())).get(0),
                addressBook.mapToRecord().apply("Wes Jackson, Male, 14/08/74"));
    }


    @Test
    public void testHowManyDaysOlderIsBillThanPaul() {
        fail();
    }
}
