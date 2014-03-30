package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class GroupModificationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void testModificationGroup(GroupData group) {

        // save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();


        Random rnd = new Random();
        int someIndex = rnd.nextInt(oldList.size() - 1);


        app.getGroupHelper().modifyGroup(someIndex, group);


        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states


        assertThat(newList, equalTo(oldList.without(someIndex).withAdded(group)));

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

