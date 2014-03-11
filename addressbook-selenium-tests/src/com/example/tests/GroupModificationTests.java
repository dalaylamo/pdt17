package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void testModificationName(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupModification(1);
        GroupData group = new GroupData();
        group.setName("new name");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
    }

    @Test
    public void testModificationHeader(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupModification(1);
        GroupData group = new GroupData();
        group.setHeader("new Header");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
    }

    @Test
    public void testModificationFooter(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupModification(1);
        GroupData group = new GroupData();
        group.setFooter("new Footer");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
    }

}

