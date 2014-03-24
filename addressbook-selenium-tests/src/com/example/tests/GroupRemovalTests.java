package com.example.tests;


import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class GroupRemovalTests extends TestBase {
    @Test
    public void deleteSomeGrouop(){
        app.navigateTo().mainPage();
        app.navigateTo().groupsPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //remove random group
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        app.getGroupHelper().deleteGroup(index);


        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        oldList.remove(index);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
