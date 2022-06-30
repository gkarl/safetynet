package com.SafetyNet.alerts.repository;

import com.SafetyNet.alerts.model.Database;
import com.SafetyNet.alerts.model.Firestation;
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

    // URL endpoints

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
