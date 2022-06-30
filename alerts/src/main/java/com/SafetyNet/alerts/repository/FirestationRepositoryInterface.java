package com.SafetyNet.alerts.repository;

import com.SafetyNet.alerts.model.Firestation;

import java.util.List;

public interface FirestationRepositoryInterface {

    List<Firestation> findFirestationAll();

    // URL endpoint

    List<Firestation> findAddressByStation(int stationNumber);


}
