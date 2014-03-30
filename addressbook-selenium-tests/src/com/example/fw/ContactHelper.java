package com.example.fw;

import com.example.tests.ContactData;
import com.example.utils.ListOf;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {

    public static boolean CREATION = true;
    public static boolean MODIFICATION = false;

    private SortedListOf<ContactData> cachedContacts;

    public SortedListOf<ContactData> getContacts() {
        manager.navigateTo().mainPage();
        if (cachedContacts == null) {
            rebuildCache();
        }
        return cachedContacts;
    }

    private void rebuildCache() {
        manager.navigateTo().mainPage();
        cachedContacts = new SortedListOf<ContactData>();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@accept]"));

        for (int i = 0; i < checkboxes.size(); i++) {
            WebElement lastName = driver.findElement(By.xpath("//tbody/tr[" + (i + 2) + "]/td[2]"));
            WebElement firstName = driver.findElement(By.xpath("//tbody/tr[" + (i + 2) + "]/td[3]"));
            WebElement eMail = driver.findElement(By.xpath("//tbody/tr[" + (i + 2) + "]/td[4]/a"));
            WebElement mobilePhone = driver.findElement(By.xpath("//tbody/tr[" + (i + 2) + "]/td[5]"));

            cachedContacts.add(new ContactData().withFirstName(firstName.getText()).withLastName(lastName.getText()).withEmailFirst(eMail.getText()).withMobilePhone(mobilePhone.getText()));

        }

    }



    public ContactHelper createContact(ContactData contact, boolean typeOfOperation) {
        initContactCreation();
        fillOutForm(contact, typeOfOperation);
        submitContactCreation();
        return this;
    }




    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
        cachedContacts = null;
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
        //click(By.xpath("//a[@href='edit.php?id=" + 110 + "']"));
        String xpath = "//table/tbody/tr[" + (i + 2) + "]/td[7]/a";
        click(By.xpath(xpath));
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
        cachedContacts = null;
        return this;
    }

    public ContactHelper deleteContactByIndex(int contactIndex) {
        initContactModificationByIndex(contactIndex);
        clickDeleteContactButton();
        cachedContacts = null;
        return this;
    }
}
