package com.example.tests;

import org.testng.annotations.Test;
import java.util.List;
import java.util.Collections;

import static org.testng.Assert.assertEquals;
import static com.example.fw.ContactHelper.CREATION;

public class ContactCreationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void testCreatingContact(ContactData contact) throws Exception {

        app.navigateTo().mainPage();

        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();


        app.getContactHelper().createContact(contact, CREATION);


        app.navigateTo().mainPage();


        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();


        contact.setNull();
        oldList.add(contact);
        Collections.sort(newList);
        Collections.sort(oldList);

        assertEquals(newList, oldList);

    }

}
