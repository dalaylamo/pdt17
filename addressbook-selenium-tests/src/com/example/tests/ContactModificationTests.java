package com.example.tests;


import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {


    @Test (dataProvider = "randomValidContactGenerator")
    public void testContactModification(ContactData contact) {
        app.getNavigationHelper().openMainPage();

        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //modify random contact
        Random rnd = new Random();
        int someIndex = rnd.nextInt(oldList.size() - 1);

        app.getContactHelper().initContactModificationByIndex(someIndex);
        app.getContactHelper().fillOutForm(contact);
        app.getContactHelper().clickUpdateButton();
        app.getNavigationHelper().openMainPage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();
        contact.setFirstName(contact.getFirstName() + " " + contact.getLastName());

        oldList.remove(someIndex);
        oldList.add(contact);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);
    }


}
