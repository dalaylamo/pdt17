package com.example.fw;

import com.example.tests.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;


public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    private void selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + index + "]"));
    }

    public void deleteGroup(int index) {
        selectGroupByIndex(index);
        click(By.name("delete"));
    }

    public void initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public List<GroupData> getGroups() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            GroupData group = new GroupData();
            String title = checkbox.getAttribute("title");
            group.name = title.substring("Select (".length(), title.length() - ")".length()); // выбираем имя группы
            groups.add(group);
        }
        return groups;
    }
}
