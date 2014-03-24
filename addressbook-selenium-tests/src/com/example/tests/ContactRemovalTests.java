package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class ContactRemovalTests extends TestBase {

    @Test
    public void testRemoveContact() {

        app.navigateTo().mainPage();

        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //remove random contact
        Random rnd = new Random();
        int someIndex = rnd.nextInt(oldList.size() - 1);


        app.getContactHelper().deleteContactByIndex(someIndex);


        app.navigateTo().mainPage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        oldList.remove(someIndex);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);
    }
}
