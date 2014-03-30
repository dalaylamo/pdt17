package com.example.tests;


import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;




public class GroupCreationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationValidData(GroupData group) throws Exception {


        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

        app.getGroupHelper().createGroup(group);


        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states

        assertThat(newList, equalTo(oldList.withAdded(group)));


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
