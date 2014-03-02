package com.example.hw2;

    import org.testng.annotations.Test;

public class TestContact extends TestBase{

    @Test
        public void testCreatingContact() throws Exception {
            openMain();
            clickAddNew();

            ContactData contactData = new ContactData();
            contactData.setFirstName("First name");
            contactData.setLastName("Last name");
            contactData.setAddress("Address");
            contactData.setHomePhone("home phone");
            contactData.setMobilePhone("mobile phone");
            contactData.setWorkPhone("work phone");
            contactData.setEmailFirst("email1");
            contactData.setEmailSecond("email2");
            contactData.setDayOfBirth("31");
            contactData.setMonthOfBirth("March");
            contactData.setYearOfBirth("1985");
            contactData.setSelectGroup("group 1");
            contactData.setAddressSecond("second address");
            contactData.setPhoneSecond("second phone");

            fillOutForm(contactData);
            clickSubmit();
        }

}
