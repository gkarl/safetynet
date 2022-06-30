package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.model.Firestation;
import com.SafetyNet.alerts.repository.FirestationRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FirestationService implements FirestationServiceInterface {

    @Autowired
    public FirestationRepositoryInterface firestationRepositoryInterface;

    public FirestationService(FirestationRepositoryInterface firestationRepositoryInterface) {
        this.firestationRepositoryInterface = firestationRepositoryInterface;
    }

    public FirestationRepositoryInterface getFirestationRepositoryInterface() {
        return firestationRepositoryInterface;
    }

    public void setFirestationRepositoryInterface(FirestationRepositoryInterface firestationRepositoryInterface) {
        this.firestationRepositoryInterface = firestationRepositoryInterface;
    }

    @Override
    public List<Firestation> findFirestationAll() {
        return firestationRepositoryInterface.findFirestationAll();
    }

    @Override
    public List<Firestation> createFirestation(Firestation firestation) {
        firestationRepositoryInterface.createFirestation(firestation);
        return firestationRepositoryInterface.findFirestationAll();
    }

    //URL endpoint
    @Override
    public List<Firestation> findAddressByStation(int stationNumber) {
        return firestationRepositoryInterface.findAddressByStation(stationNumber);
    }
}
