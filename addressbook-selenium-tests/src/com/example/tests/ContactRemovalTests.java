package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContactRemovalTests extends TestBase {

    @Test
    public void testRemoveContact() {

        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        //remove random contact
        Random rnd = new Random();
        int someIndex = rnd.nextInt(oldList.size() - 1);


        app.getContactHelper().deleteContactByIndex(someIndex);

        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        assertThat(newList, equalTo(oldList.without(someIndex)));

    }
}
