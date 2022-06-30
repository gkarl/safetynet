package com.SafetyNet.alerts.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CalculeService {

    private long adults = 0;
    private long childrens = 0;
    private int age = 0;
    private final List<Integer> listAgeCalcule = new ArrayList<Integer>();

    public long getAdults() {
        return adults;
    }

    public void setAdults(long adults) {
        this.adults = adults;
    }

    public long getChildren() {
        return childrens;
    }

    public void setChildren(long children) {
        this.childrens = children;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getListAgeCalcule() {
        return listAgeCalcule;
    }

    public void calculateAge(String birthDay){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        age = Period.between(LocalDate.parse(birthDay, dateTimeFormatter), LocalDate.now()).getYears();
        listAgeCalcule.add(age);
        if (age > 18){
            adults++;
        } else {
            childrens++;
        }
    }


}
