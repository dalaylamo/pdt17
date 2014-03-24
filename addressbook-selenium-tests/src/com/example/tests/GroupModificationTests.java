package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @Test (dataProvider = "randomValidGroupGenerator")
    public void testModificationName(GroupData group){

        // save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();


        Random rnd = new Random();
        int someIndex = rnd.nextInt(oldList.size() - 1);


        app.getGroupHelper().modifyGroup(someIndex, group);


        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        oldList.remove(0);
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);

    }

/*    @Test
    public void testModificationHeader(){
        app.navigateTo().mainPage();
        app.navigateTo().groupsPage();

        List<GroupData> oldList = app.getGroupHelper().getGroups();

        app.getGroupHelper().initGroupModification(0);
        GroupData group = new GroupData();
        group.setHeader("new Header");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        oldList.remove(0);
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);

    }

    @Test
    public void testModificationFooter(){
        app.navigateTo().mainPage();
        app.navigateTo().groupsPage();

        List<GroupData> oldList = app.getGroupHelper().getGroups();

        app.getGroupHelper().initGroupModification(0);
        GroupData group = new GroupData();
        group.setFooter("new Footer");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        oldList.remove(0);
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
  */
}

