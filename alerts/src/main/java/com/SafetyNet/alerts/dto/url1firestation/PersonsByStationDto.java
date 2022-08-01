package com.SafetyNet.alerts.dto.url1firestation;

import com.SafetyNet.alerts.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class PersonsByStationDto {

    @JsonIgnoreProperties({"city","zip","email"})
    private List<Person> listPersonsStation;
    private long adults;
    private long children;

    public void setListPersonsStation(List<Person> listPersonsStation) {
        this.listPersonsStation = listPersonsStation;
    }

    public long getAdults() {
        return adults;
    }

    public void setAdults(long adults) {
        this.adults = adults;
    }

    public long getChildren() {
        return children;
    }

    public void setChildren(long children) {
        this.children = children;
    }

    public PersonsByStationDto(List<Person> listPersonsStation, long adults, long children) {
        this.listPersonsStation = listPersonsStation;
        this.adults = adults;
        this.children = children;
    }

    public PersonsByStationDto(){}

/*    public PersonsByStationDto(List<Person> listPersonsStation) {
        this.listPersonsStation = listPersonsStation;
    }*/

    public List<Person> getListPersonsStation(){
        return listPersonsStation;
    }

    @Override
    public String toString(){
        return "PersonsByStationDto [listPersonsStation=" + getListPersonsStation() + ", adults=" + getAdults() + ", children=" + getChildren() + "]";
    }
}
