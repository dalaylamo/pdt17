package com.example.tests;


import com.example.utils.SortedListOf;
import org.testng.annotations.Test;


import java.util.Random;

import static com.example.fw.ContactHelper.MODIFICATION;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactModificationTests extends TestBase {


    @Test (dataProvider = "randomValidContactGenerator")
    public void testContactModification(ContactData contact) {


        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        //modify random contact
        Random rnd = new Random();
        int someIndex = rnd.nextInt(oldList.size() - 1);

        app.getContactHelper().modifyContact(contact, someIndex, MODIFICATION);


        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        //contact.setNull();

        assertThat(newList, equalTo(oldList.without(someIndex).withAdded(contact)));
    }


}
