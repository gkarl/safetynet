package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.model.Firestation;
import com.SafetyNet.alerts.service.FirestationServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirestationController {

    Logger logger = LoggerFactory.getLogger(FirestationController.class);

    @Autowired
    FirestationServiceInterface firestationServiceInterface;

    public FirestationServiceInterface getFirestationServiceInterface() {
        return firestationServiceInterface;
    }

    public void setFirestationServiceInterface(FirestationServiceInterface firestationServiceInterface) {
        this.firestationServiceInterface = firestationServiceInterface;
    }


    @GetMapping("/firestations")
    public List<Firestation> findFirestationAll(){
        List<Firestation> findFirestation = firestationServiceInterface.findFirestationAll();
        if (findFirestation != null){
            logger.info("GET findFirestationAll SUCCESS");
        } else {
            logger.info("GET findFirestationAll FAILED");
        }
        return findFirestation;
    }

    @PostMapping("/firestation")
    public List<Firestation> createFirestation(@RequestBody Firestation firestation){
        List<Firestation> newFirestationList = firestationServiceInterface.createFirestation(firestation);
        if (newFirestationList != null){
            logger.info("POST createFirestation SUCCESS");
        } else {
            logger.info("POST createFirestation FAILED");
        }
        return newFirestationList;
    }

    @PutMapping("/firestation")
    public Firestation updateFirestation(@RequestBody Firestation firestation){
        Firestation updateFirestationOutput = firestationServiceInterface.updateFirestation(firestation);
        if (updateFirestationOutput != null){
            logger.info("PUT updateFirestation SUCCESS");
        } else {
            logger.info("PUT updateFirestation FAILED");
        }
        return updateFirestationOutput;
    }


}
