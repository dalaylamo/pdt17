package com.example.fw;

import org.openqa.selenium.By;


public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void mainPage() {
        if (! onMainPage()) {
            click(By.linkText("home"));
        }
     }

    private boolean onMainPage() {
        return driver.findElements(By.id("maintable").).size() > 0 ;
    }

    public void groupsPage() {
        if (!onGroupsPage()){
         driver.findElement(By.linkText("groups")).click();
        }
    }

    private boolean onGroupsPage() {
        if (driver.findElements(By.name("new").).size() > 0 && driver.getTitle().contains("Groups")){
        return true;
        }
        else {
            return false;
        }
    }
}
