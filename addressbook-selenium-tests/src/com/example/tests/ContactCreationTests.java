package com.example.tests;


import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static com.example.fw.ContactHelper.CREATION;

public class ContactCreationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void testCreatingContact(ContactData contact) throws Exception {


        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();


        app.getContactHelper().createContact(contact, CREATION);


        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();



        assertThat(newList, equalTo(oldList.withAdded(contact)));

    }

}
