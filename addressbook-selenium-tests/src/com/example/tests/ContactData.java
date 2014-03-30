package com.example.tests;

public class ContactData implements Comparable<ContactData> {
    private String firstName;
    private String lastName;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String emailFirst;
    private String emailSecond;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
    private String selectGroup;
    private String addressSecond;
    private String phoneSecond;

    public ContactData() {
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
//        if (Integer.parseInt(dayOfBirth) < 32 && (Integer.parseInt(dayOfBirth)) > 0)
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

    public ContactData withFirstName(String name){
        this.setFirstName(name);
        return this;
    }

    public ContactData withLastName(String lastName){
        this.setLastName(lastName);
        return this;
    }

    public ContactData withAddress(String address){
        this.setAddress(address);
        return this;
    }

    public ContactData withAddressSecond(String addressSecond){
        this.setAddressSecond(addressSecond);
        return this;
    }

    public ContactData withHomePhone(String homePhone){
        this.setHomePhone(homePhone);
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone){
        this.setMobilePhone(mobilePhone);
        return this;
    }

    public ContactData withWorkPhone(String workPhone){
        this.setWorkPhone(workPhone);
        return this;
    }

    public ContactData withEmailFirst(String emailFirst){
        this.setEmailFirst(emailFirst);
        return this;
    }

    public ContactData withEmailSecond(String emailSecond){
        this.setEmailSecond(emailSecond);
        return this;
    }

    public ContactData withPhoneSecond(String phoneSecond){
        this.setPhoneSecond(phoneSecond);
        return this;
    }

    public ContactData withDayOfBirth(String dayOfBirth){
        this.setDayOfBirth(dayOfBirth);
        return this;
    }

    public ContactData withMonthOfBirth(String monthOfBirth){
        this.setMonthOfBirth(monthOfBirth);
        return this;
    }

    public ContactData withYearOfBirth(String yearOfBirth){
        this.setYearOfBirth(yearOfBirth);
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (emailFirst != null ? !emailFirst.equals(that.emailFirst) : that.emailFirst != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (emailFirst != null ? emailFirst.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", emailFirst='" + emailFirst + '\'' +
                ", emailSecond='" + emailSecond + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", monthOfBirth='" + monthOfBirth + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", selectGroup='" + selectGroup + '\'' +
                ", addressSecond='" + addressSecond + '\'' +
                ", phoneSecond='" + phoneSecond + '\'' +
                '}';
    }

    @Override
    public int compareTo(ContactData other) {
        int lastNameResult = this.getLastName().toLowerCase().compareTo(other.getLastName().toLowerCase());
        if (lastNameResult != 0) {
            return lastNameResult;
        } else {
            return this.getFirstName().toLowerCase().compareTo(other.getFirstName().toLowerCase());
        }
    }

    public void setNull() {
        setYearOfBirth(null);
        setHomePhone(null);
        setAddress(null);
        setWorkPhone(null);
        setPhoneSecond(null);
        setDayOfBirth(null);
        setSelectGroup(null);
        setEmailSecond(null);
        setMonthOfBirth(null);
        setAddressSecond(null);

    }
}
