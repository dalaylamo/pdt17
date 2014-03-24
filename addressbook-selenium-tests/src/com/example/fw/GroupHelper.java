package com.example.fw;

import com.example.tests.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class GroupHelper extends HelperBase {

    public List<GroupData> getGroups() {
        manager.navigateTo().groupsPage();
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            String title = checkbox.getAttribute("title");
            String name = title.substring("Select (".length(), title.length() - ")".length()); // выбираем имя группы
            groups.add(new GroupData().withName(name));
        }
        return groups;
    }

    public GroupHelper createGroup(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
        return this;
    }

    public GroupHelper deleteGroup(int index) {
        selectGroupByIndex(index);
        submitGroupDeletion();
        returnToGroupsPage();
        return this;
    }



    public GroupHelper modifyGroup(int someIndex, GroupData group) {
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupsPage();
        return this;
    }

    //=================================================================================================================

    public GroupHelper(ApplicationManager manager) {
        super(manager);
        return this;
    }

    public GroupHelper initGroupCreation() {
        click(By.name("new"));
        return this;
    }

    public void submitGroupDeletion() {
        click(By.name("delete"));
    }

    public GroupHelper submitGroupCreation() {
        click(By.name("submit"));
        return this;
    }

    public GroupHelper returnToGroupsPage() {
        click(By.linkText("group page"));
        return this;
    }

    public GroupHelper fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
        return this;
    }

    private GroupHelper selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
        return this;
    }


    public GroupHelper initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
        return this;
    }

    public GroupHelper submitGroupModification() {
        click(By.name("update"));
        return this;
    }



}
