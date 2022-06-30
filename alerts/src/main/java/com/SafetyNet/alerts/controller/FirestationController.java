package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.model.Firestation;
import com.SafetyNet.alerts.service.FirestationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FirestationController {

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
        return findFirestation;
    }

    @PostMapping("/firestation")
    public List<Firestation> createFirestation(@RequestBody Firestation firestation){
        List<Firestation> newFirestationList = firestationServiceInterface.createFirestation(firestation);
        return newFirestationList;
    }
}
