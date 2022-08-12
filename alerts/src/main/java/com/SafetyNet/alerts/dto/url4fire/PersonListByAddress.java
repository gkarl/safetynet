package com.SafetyNet.alerts.dto.url4fire;

import com.SafetyNet.alerts.model.Firestation;

import java.util.List;

public class PersonListByAddress {

    private Firestation firestationNumber;
    private List<PersonFireAddress> listPersonsByAddress;

    public PersonListByAddress(Firestation firestationNumber, List<PersonFireAddress> listPersonsByAddress) {
        this.firestationNumber = firestationNumber;
        this.listPersonsByAddress = listPersonsByAddress;
    }

    public Firestation getFirestationNumber() {
        return firestationNumber;
    }

    public void setFirestationNumber(Firestation firestationNumber) {
        this.firestationNumber = firestationNumber;
    }

    public List<PersonFireAddress> getListPersonsByAddress() {
        return listPersonsByAddress;
    }

    public void setListPersonsByAddress(List<PersonFireAddress> listPersonsByAddress) {
        this.listPersonsByAddress = listPersonsByAddress;
    }

    @Override
    public String toString(){
        return "firestationNumber [" + getFirestationNumber() + ", " + getListPersonsByAddress() + "]";
    }
}
