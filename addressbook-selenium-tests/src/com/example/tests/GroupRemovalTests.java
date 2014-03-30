package com.example.tests;


import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

public class GroupRemovalTests extends TestBase {
    @Test
    public void deleteSomeGrouop(){
        //save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

        //remove random group
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        app.getGroupHelper().deleteGroup(index);


        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

        assertThat(newList, equalTo(oldList.without(index)));
    }
}
