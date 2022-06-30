package com.SafetyNet.alerts.repository;

import com.SafetyNet.alerts.model.Firestation;
import com.SafetyNet.alerts.model.Person;

import java.util.List;

public interface FirestationRepositoryInterface {

    List<Firestation> findFirestationAll();

    List<Firestation> createFirestation(Firestation firestation);

    // URL endpoint

    List<Firestation> findAddressByStation(int stationNumber);


}
