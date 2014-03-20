package com.example.tests;

import org.testng.annotations.Test;
import java.util.List;
import java.util.Collections;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void testCreatingContact(ContactData contact) throws Exception {

        app.getNavigationHelper().openMainPage();

        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillOutForm(contact);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().openMainPage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        contact.setFirstName(contact.getFirstName() + " " + contact.getLastName());
        oldList.add(contact);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);

    }

}
