package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.model.Firestation;
import com.SafetyNet.alerts.repository.FirestationRepositoryInterface;

import java.util.List;

public interface FirestationServiceInterface {

    void setFirestationRepositoryInterface(FirestationRepositoryInterface firestationRepositoryInterface);
    List<Firestation> findFirestationAll();

    // URL endpoints

    List<Firestation> findAddressByStation(int stationNumber);

}
