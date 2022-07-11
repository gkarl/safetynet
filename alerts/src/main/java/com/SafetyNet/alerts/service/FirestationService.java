package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.model.Firestation;
import com.SafetyNet.alerts.repository.FirestationRepositoryInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FirestationService implements FirestationServiceInterface {

    Logger logger = LoggerFactory.getLogger(FirestationService.class);

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
        logger.info("GET all Firestation SUCCESS");
        return firestationRepositoryInterface.findFirestationAll();
    }

    @Override
    public List<Firestation> createFirestation(Firestation firestation) {
        logger.info("Create Firestation SUCCESS :" + firestation);
        return firestationRepositoryInterface.createFirestation(firestation);
    }

    @Override
    public Firestation updateFirestation(Firestation firestation) {
        logger.info("Update Firestation SUCCESS :" + firestation);
        return firestationRepositoryInterface.updateFirestation(firestation);
    }

    @Override
    public List<Firestation> deleteFirestation(String address) {
        logger.info("deleteFirestation SUCCESS :" + address);
        firestationRepositoryInterface.deleteFirestation(address);
        return firestationRepositoryInterface.findFirestationAll();
    }

    //URL endpoint
    @Override
    public List<Firestation> findAddressByStation(int stationNumber) {
        logger.info("findAddressByStation SUCCESS :");
        return firestationRepositoryInterface.findAddressByStation(stationNumber);
    }
}
