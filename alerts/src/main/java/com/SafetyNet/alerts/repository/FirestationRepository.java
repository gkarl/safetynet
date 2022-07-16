package com.SafetyNet.alerts.repository;

import com.SafetyNet.alerts.model.Database;
import com.SafetyNet.alerts.model.Firestation;
import com.SafetyNet.alerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FirestationRepository implements FirestationRepositoryInterface{

    @Autowired
    private Database database;


    @Override
    public List<Firestation> findFirestationAll() {
        return database.getFirestations();
    }

    @Override
    public List<Firestation> createFirestation(Firestation firestation) {
        List<Firestation> saveFirestationList = database.getFirestations();
        saveFirestationList.add(firestation);
        return saveFirestationList;
    }

    @Override
    public Firestation updateFirestation(Firestation firestation) {
        List<Firestation> updateFirestationList = database.getFirestations();
        for (Firestation update : updateFirestationList){
            if (update.getAddress().equals(firestation.getAddress())){
                update.setStation(firestation.getStation());
                return update;
            }
        }
        return null;
    }

    @Override
    public void deleteFirestation(String address) {
        List<Firestation> firestationList = database.getFirestations();
        firestationList.removeIf(firestation -> firestation.getAddress().equals(address));
    }


    // URL endpoints

    @Override
    public Firestation findById(String firestationAddress) {
        for (Firestation address : database.getFirestations()){
            if (address.getAddress().equals(firestationAddress)){
                return address;
            }
        }
        return null;
    }

    @Override
    public List<Firestation> findAddressByStation(int stationNumber) {
        List<Firestation> listFirestation = new ArrayList<Firestation>();
        for (Firestation firestation : database.getFirestations()){
            if(firestation.getStation() == stationNumber){
                listFirestation.add(firestation);
            }
        }
        return listFirestation;
    }


}
