package com.example.tests;


import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;


import static org.testng.Assert.assertEquals;
import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactModificationTests extends TestBase {


    @Test (dataProvider = "randomValidContactGenerator")
    public void testContactModification(ContactData contact) {
        app.navigateTo().mainPage();

        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //modify random contact
        Random rnd = new Random();
        int someIndex = rnd.nextInt(oldList.size() - 1);

        app.getContactHelper().modifyContact(contact, someIndex, MODIFICATION);

        app.navigateTo().mainPage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();


        oldList.remove(someIndex);
        contact.setNull();
        oldList.add(contact);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);
    }


}
