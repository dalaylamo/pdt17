package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {

    public static boolean CREATION = true;
    public static boolean MODIFICATION = false;


    public ContactHelper createContact(ContactData contact, boolean typeOfOperation) {
        initContactCreation();
        fillOutForm(contact, typeOfOperation);
        submitContactCreation();
        return this;
    }


    public List<ContactData> getContacts() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@accept]"));

        for (int i = 0; i < checkboxes.size(); i++) {
            WebElement lastName = driver.findElement(By.xpath("//tbody/tr[" + (i + 2) + "]/td[2]"));
            WebElement firstName = driver.findElement(By.xpath("//tbody/tr[" + (i + 2) + "]/td[3]"));
            WebElement eMail = driver.findElement(By.xpath("//tbody/tr[" + (i + 2) + "]/td[4]/a"));
            WebElement mobilePhone = driver.findElement(By.xpath("//tbody/tr[" + (i + 2) + "]/td[5]"));
            ContactData contact = new ContactData();

            //String title = checkbox.getAttribute("title");
            //String field = title.substring(8,title.length() - 1);
            //contact.setFirstName(field);

            contact.setFirstName(firstName.getText());
            contact.setLastName(lastName.getText());
            contact.setEmailFirst(eMail.getText());
            contact.setMobilePhone(mobilePhone.getText());
            contacts.add(contact);
        }
        return contacts;
    }




    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillOutForm(ContactData contactData, boolean formType) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmailFirst());
        type(By.name("email2"), contactData.getEmailSecond());
        selectByText(By.name("bday"), contactData.getDayOfBirth());
        selectByText(By.name("bmonth"), contactData.getMonthOfBirth());
        type(By.name("byear"), contactData.getYearOfBirth());
        if (formType == CREATION){
            //selectByText(By.name("new_group"), contactData.getSelectGroup());
        }
        else {
            if (driver.findElements(By.name("new_group")).size() != 0) {
                throw new Error("Group selector exists in contact modification form");
            }
        }

        type(By.name("address2"), contactData.getAddressSecond());
        type(By.name("phone2"), contactData.getPhoneSecond());
    }

    public void selectContactByIndex(int index){
        click(By.id("id" + index));
    }

    public void initContactModificationByIndex(int i) {
       // click(By.xpath("//a[@href='edit.php?id=" + i + "']"));
        click(By.xpath("//table/tbody/tr[" + (i + 2) + "]/td[7]"));
    }

    public void clickDeleteContactButton(){
        click(By.xpath("//input[@value='Delete']"));
    }

    public void clickUpdateButton() {
        click(By.xpath("//input[@value='Update']"));
    }


    public ContactHelper modifyContact(ContactData contact,int indexOfContact, boolean typeOfOperation) {
        initContactModificationByIndex(indexOfContact);
        fillOutForm(contact, typeOfOperation);
        clickUpdateButton();
        return this;
    }

    public ContactHelper deleteContactByIndex(int contactIndex) {
        initContactModificationByIndex(contactIndex);
        clickDeleteContactButton();
        return this;
    }
}
