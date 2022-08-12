package com.SafetyNet.alerts.dto.url2childAlert;

import java.util.List;

public class ChildByAddressDto {

    private List<PersonsWithAge> children;
    private List<PersonsWithAge> adults;

    public List<PersonsWithAge> getChildren() {
        return children;
    }

    public void setChildren(List<PersonsWithAge> children) {
        this.children = children;
    }

    public List<PersonsWithAge> getAdults() {
        return adults;
    }

    public void setAdults(List<PersonsWithAge> adults) {
        this.adults = adults;
    }


    @Override
    public String toString(){
        return " [children=" + getChildren() + ", adults=" + getAdults() + "]";
    }
}
