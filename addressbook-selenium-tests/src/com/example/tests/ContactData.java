package com.example.tests;

public class ContactData implements Comparable<ContactData>{
    private  String firstName;
    private String lastName;
    private  String address;
    private  String homePhone;
    private  String mobilePhone;
    private  String workPhone;
    private  String emailFirst;
    private  String emailSecond;
    private  String dayOfBirth;
    private  String monthOfBirth;
    private  String yearOfBirth;
    private  String selectGroup;
    private  String addressSecond;
    private  String phoneSecond;

    public ContactData(){
    }

    public ContactData(String firstName, String lastName, String address, String homePhone, String mobilePhone, String workPhone, String emailFirst, String emailSecond, String dayOfBirth, String monthOfBirth, String yearOfBirth, String selectGroup, String addressSecond, String phoneSecond) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.emailFirst = emailFirst;
        this.emailSecond = emailSecond;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.selectGroup = selectGroup;
        this.addressSecond = addressSecond;
        this.phoneSecond = phoneSecond;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public void setEmailFirst(String emailFirst) {
        this.emailFirst = emailFirst;
    }

    public void setEmailSecond(String emailSecond) {
        this.emailSecond = emailSecond;
    }

    public void setDayOfBirth(String dayOfBirth) {
        if (Integer.parseInt(dayOfBirth) < 32 && (Integer.parseInt(dayOfBirth)) > 0)
        this.dayOfBirth = dayOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setSelectGroup(String selectGroup) {
        this.selectGroup = selectGroup;
    }

    public void setAddressSecond(String addressSecond) {
        this.addressSecond = addressSecond;
    }

    public void setPhoneSecond(String phoneSecond) {
        this.phoneSecond = phoneSecond;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getEmailFirst() {
        return emailFirst;
    }

    public String getEmailSecond() {
        return emailSecond;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getSelectGroup() {
        return selectGroup;
    }

    public String getAddressSecond() {
        return addressSecond;
    }

    public String getPhoneSecond() {
        return phoneSecond;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                //", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(ContactData other) {
        return this.getFirstName().toLowerCase().compareTo(other.getFirstName().toLowerCase());
    }
}
