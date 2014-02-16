package com.gmail.tlachy.gumtree;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

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
        fail();
    }

    @Test
    public void testHowIsOldest() {
        fail();

    }

    @Test
    public void testHowManyDaysOlderIsBillThanPaul() {
        fail();
    }
}
