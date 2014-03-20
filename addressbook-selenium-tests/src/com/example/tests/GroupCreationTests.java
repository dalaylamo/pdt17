package com.example.tests;



import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.List;
import java.util.Collections;


public class GroupCreationTests extends TestBase {

    @Test (dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationValidData(GroupData group) throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        List<GroupData> oldList = app.getGroupHelper().getGroups();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);


    }

   /* @Test
    public void testGroupCreationInvalidData() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        List<GroupData> oldList = app.getGroupHelper().getGroups();
        app.getGroupHelper().initGroupCreation();
        GroupData group = new GroupData("", "", "");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        List<GroupData> newList = app.getGroupHelper().getGroups();
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);

    } */

}
