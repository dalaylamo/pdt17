package com.example.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupDataGenerator {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please specify parameters: <amount of test data> <file> <format>");
            return;
        }
        int amount = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        String format = args[2];

        List<GroupData> groups = generateRandomGroups(amount);
        if ("csv".equals(format)) {
            saveGroupToCsvFile (groups, file);
        } else if ("xml".equals(format)) {
            saveGroupToXmlFile (groups, file);
        } else {
            System.out.println("Unknown format");
            return;
        }
    }

    private static void saveGroupToXmlFile(List<GroupData> groups, File file) {
    }

    private static void saveGroupToCsvFile(List<GroupData> groups, File file) {
    }

    public static List<GroupData> generateRandomGroups(int amount) {
        List<GroupData> list = new ArrayList<GroupData>();

        for (int i = 0; i < amount; i++) {
            GroupData group = new GroupData()
                    .withName(generateRandomString())
                    .withHeader(generateRandomString())
                    .withFooter(generateRandomString());
            list.add(group);
        }
        return list;
    }

    public static String generateRandomString(){
        Random rnd = new Random();
        if(rnd.nextInt(4) == 1) {
            return "";
        }
        else return "test" + rnd.nextInt();
    }
}
