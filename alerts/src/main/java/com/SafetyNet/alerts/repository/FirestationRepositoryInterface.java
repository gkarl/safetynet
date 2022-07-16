package com.SafetyNet.alerts.repository;

import com.SafetyNet.alerts.model.Firestation;
import com.SafetyNet.alerts.model.Person;

import java.util.List;

public interface FirestationRepositoryInterface {

    List<Firestation> findFirestationAll();

    List<Firestation> createFirestation(Firestation firestation);

    Firestation updateFirestation(Firestation firestation);

    void deleteFirestation(String address);

    // URL endpoint

    Firestation findById(String firestationAddress);

    List<Firestation> findAddressByStation(int stationNumber);



}
