package com.example.hw1;

import org.testng.annotations.Test;
public class GroupCreationTests extends TestBase{

    @Test
        public void testNonEmptyGroupCreation() throws Exception {
            openMainPage();
            gotoGroupsPage();
            initGroupCreation();
            GroupData group = new GroupData();
            group.setName("group 1");
            group.setHeader("header 1");
            group.setFooter("footer 1");
            fillGroupForm(group);
            submitGroupCreation();
            returnToGroupsPage();

        }

        @Test
        public void testEmptyGroupCreation() throws Exception {
            openMainPage();
            gotoGroupsPage();
            initGroupCreation();
            fillGroupForm(new GroupData("", "", ""));
            submitGroupCreation();
            returnToGroupsPage();

    }

}
