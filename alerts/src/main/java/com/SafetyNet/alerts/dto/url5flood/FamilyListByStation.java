package com.SafetyNet.alerts.dto.url5flood;

import java.util.List;

public class FamilyListByStation {

    private String lastName;
    private final String phone;
    private int age;
    private final List<String> medications;
    private final List<String> allergies;

    public FamilyListByStation(String lastName, String phone, int age, List<String> medications, List<String> allergies) {
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.medications = medications;
        this.allergies = allergies;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getMedications() {
        return medications;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    @Override
    public String toString(){
        return "Flood [" + getLastName() + ", " + getPhone() + ", " + getAge() + ", " + getMedications() + ", " + getAllergies() + "]";
    }
}
