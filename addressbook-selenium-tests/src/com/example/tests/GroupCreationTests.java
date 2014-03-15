package com.example.tests;



import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Collections;

public class GroupCreationTests extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        List<GroupData> oldList = app.getGroupHelper().getGroups();
        app.getGroupHelper().initGroupCreation();
        GroupData group = new GroupData();
        group.setName("group Tratata");
        group.setHeader("header 1");
        group.setFooter("footer 1");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

        List<GroupData> newList = app.getGroupHelper().getGroups();

        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);


    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
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

    }

}
