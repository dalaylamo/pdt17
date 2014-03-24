package com.example.tests;


import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class GroupCreationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationValidData(GroupData group) throws Exception {


        List<GroupData> oldList = app.getGroupHelper().getGroups();

        app.getGroupHelper().createGroup(group);


        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);


    }

   /* @Test
    public void testGroupCreationInvalidData() throws Exception {
        app.navigateTo().mainPage();
        app.navigateTo().groupsPage();
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
