package com.example.tests;



import com.example.fw.ApplicationManager;
import org.apache.commons.collections.iterators.ArrayListIterator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class TestBase {

    public static ApplicationManager app;



    @BeforeTest
    public void setUp() throws Exception {
        app = new ApplicationManager();

    }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();

    }

    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator() {
        List<Object[]> list = new ArrayList<Object[]>();

        for (int i = 0; i < 7; i++) {
            GroupData group = new GroupData()
                    .withName(generateRandomString())
                    .withHeader(generateRandomString())
                    .withFooter(generateRandomString());
            list.add(new Object[]{group});
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactGenerator(){
        List<Object[]> list = new ArrayList<Object[]>();

        for (int i = 0; i < 1; i++) {
            ContactData contact = new ContactData()
                    .withEmailFirst(generateRandomString())
                    .withAddressSecond(generateRandomString())
                    .withAddress(generateRandomString())
                    .withYearOfBirth(generateRandomYear())
            //contact.setMonthOfBirth(generateRandomMonth());
                    .withDayOfBirth(generateRandomDay())
                    .withWorkPhone(generateRandomString())
                    .withFirstName(generateRandomString())
                    .withMobilePhone(generateRandomString())
                    .withEmailSecond(generateRandomString())
                    .withLastName(generateRandomString())
                    .withPhoneSecond(generateRandomString());
            list.add(new Object[]{contact});
        }
        return list.iterator();
    }

    public String generateRandomDay(){
        Random rnd = new Random();
        return rnd.nextInt(30) + 1 + "";
    }

    public String generateRandomYear(){
        Random rnd = new Random();
        return rnd.nextInt(100) + 1914 + "";
    }



    public String generateRandomString(){
        Random rnd = new Random();
        if(rnd.nextInt(4) == 1) {
            return "";
        }
        else return "test" + rnd.nextInt();
    }
}
