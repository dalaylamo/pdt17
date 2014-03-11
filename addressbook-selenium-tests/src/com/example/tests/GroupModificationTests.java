package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void deleteSomeGrouop(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupModification(1);
        GroupData group = new GroupData();
        group.setName("new name");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
    }
}
