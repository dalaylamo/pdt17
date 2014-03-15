package com.example.tests;


import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testAddressModification() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModificationByIndex(3);
        ContactData contact = new ContactData();
        contact.setAddress("New address");
        app.getContactHelper().fillOutForm(contact);
        app.getContactHelper().clickUpdateButton();
        app.getNavigationHelper().openMainPage();
    }

    @Test
    public void testAddressSecondModification() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModificationByIndex(3);
        ContactData contact = new ContactData();
        contact.setAddressSecond("New address Second");
        app.getContactHelper().fillOutForm(contact);
        app.getContactHelper().clickUpdateButton();
    }

    @Test
    public void testEmailFirstModification() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModificationByIndex(3);
        ContactData contact = new ContactData();
        contact.setEmailFirst("New first email");
        app.getContactHelper().fillOutForm(contact);
        app.getContactHelper().clickUpdateButton();
    }

    @Test
    public void testEmailSecondModification() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModificationByIndex(3);
        ContactData contact = new ContactData();
        contact.setEmailSecond("New second email");
        app.getContactHelper().fillOutForm(contact);
        app.getContactHelper().clickUpdateButton();
    }

    @Test
    public void testHomePhoneModification() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModificationByIndex(3);
        ContactData contact = new ContactData();
        contact.setHomePhone("New home phone");
        app.getContactHelper().fillOutForm(contact);
        app.getContactHelper().clickUpdateButton();
    }

    @Test
    public void testFirstNameModification() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModificationByIndex(3);
        ContactData contact = new ContactData();
        contact.setFirstName("New first name");
        app.getContactHelper().fillOutForm(contact);
        app.getContactHelper().clickUpdateButton();
    }

    @Test
    public void testLastNameModification() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModificationByIndex(3);
        ContactData contact = new ContactData();
        contact.setLastName("New last name");
        app.getContactHelper().fillOutForm(contact);
        app.getContactHelper().clickUpdateButton();
    }

    @Test
    public void testMobilePhoneModification() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModificationByIndex(3);
        ContactData contact = new ContactData();
        contact.setMobilePhone("New mobile phone");
        app.getContactHelper().fillOutForm(contact);
        app.getContactHelper().clickUpdateButton();
    }

    @Test
    public void testPhoneSecondModification() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModificationByIndex(3);
        ContactData contact = new ContactData();
        contact.setPhoneSecond("New phone second");
        app.getContactHelper().fillOutForm(contact);
        app.getContactHelper().clickUpdateButton();
    }

    @Test
    public void testWorkPhoneModification() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModificationByIndex(3);
        ContactData contact = new ContactData();
        contact.setWorkPhone("New work phone");
        app.getContactHelper().fillOutForm(contact);
        app.getContactHelper().clickUpdateButton();
    }

    @Test
    public void testDateOfBirthModification() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModificationByIndex(3);
        ContactData contact = new ContactData();
        contact.setDayOfBirth("2");
        contact.setMonthOfBirth("January");
        contact.setYearOfBirth("1970");
        app.getContactHelper().fillOutForm(contact);
        app.getContactHelper().clickUpdateButton();
        app.getNavigationHelper().openMainPage();
    }
}
