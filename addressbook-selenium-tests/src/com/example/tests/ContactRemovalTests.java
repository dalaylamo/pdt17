package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void testRemoveContact(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModificationByIndex(4);
        app.getContactHelper().clickDeleteContactButton();
    }
}
