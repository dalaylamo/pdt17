package com.example.tests;

public class GroupData implements Comparable<GroupData> {
    public String name;
    public  String header;
    public String footer;

    public GroupData() {
    }

    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
     return "GroupData [name=" + getName() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (name != null ? !name.equals(groupData.name) : groupData.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public int compareTo(GroupData other) {
        return this.getName().toLowerCase().compareTo(other.getName().toLowerCase());
    }
}
