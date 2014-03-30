package com.example.fw;

import com.example.tests.GroupData;
import com.example.utils.ListOf;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;


public class GroupHelper extends HelperBase {

    private SortedListOf<GroupData> cachedGroups;

    public SortedListOf<GroupData> getGroups() {
        manager.navigateTo().groupsPage();
        if (cachedGroups == null) {
            rebuildCache();
        }
        return cachedGroups;


    }

    private void rebuildCache() {
        manager.navigateTo().groupsPage();
        cachedGroups = new SortedListOf<GroupData>();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            String title = checkbox.getAttribute("title");
            String name = title.substring("Select (".length(), title.length() - ")".length()); // выбираем имя группы
            cachedGroups.add(new GroupData().withName(name));
        }

    }

    public GroupHelper createGroup(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
        rebuildCache();
        return this;
    }

    public GroupHelper deleteGroup(int index) {
        selectGroupByIndex(index);
        submitGroupDeletion();
        returnToGroupsPage();
        rebuildCache();
        return this;
    }



    public GroupHelper modifyGroup(int someIndex, GroupData group) {
        initGroupModification(someIndex);
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupsPage();
        rebuildCache();
        return this;
    }

    //=================================================================================================================

    public GroupHelper(ApplicationManager manager) {
        super(manager);

    }

    public GroupHelper initGroupCreation() {
        click(By.name("new"));

        return this;
    }

    public void submitGroupDeletion() {
        click(By.name("delete"));
        cachedGroups = null;
    }

    public GroupHelper submitGroupCreation() {
        click(By.name("submit"));
        cachedGroups = null;
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
        cachedGroups = null;
        return this;
    }



}
