package com.SafetyNet.alerts.dto.url1firestation;



public class PersonsByFirestation {

    private String firstName;
    private String lastName;
    private String address;
    private final String phone;

    public PersonsByFirestation(String firstName, String lastName, String address, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString(){
        return "listPersonsStation [firstName=" + getFirstName() + ", lastName=" + getLastName() + ", address=" + getAddress() + ", phone=" + getPhone() + "]";
    }
}
