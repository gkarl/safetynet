package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.model.Medicalrecord;
import com.SafetyNet.alerts.service.MedicalrecordServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MedicalrecordController {

    Logger logger = LoggerFactory.getLogger(MedicalrecordController.class);

    @Autowired
    MedicalrecordServiceInterface medicalrecordServiceInterface;

    public MedicalrecordServiceInterface getMedicalrecordServiceInterface() {
        return medicalrecordServiceInterface;
    }

    public void setMedicalrecordServiceInterface(MedicalrecordServiceInterface medicalrecordServiceInterface) {
        this.medicalrecordServiceInterface = medicalrecordServiceInterface;
    }

    @GetMapping("/medicalrecords")
    public List<Medicalrecord> findMedicalRecordAll(){
        List<Medicalrecord> getMedicalrecord = medicalrecordServiceInterface.findMedicalRecordAll();
        if (getMedicalrecord != null){
            logger.info("GET findMedicalRecordAll SUCCESS");
        } else {
            logger.info("GET findMedicalRecordAll FAILED");
        }
        return getMedicalrecord;
    }

    @PostMapping("medicalrecord")
    List<Medicalrecord> createMedicalRecord(@RequestBody Medicalrecord medicalrecord){
        List<Medicalrecord> saveMedicalRecordList = medicalrecordServiceInterface.createMedicalrecord(medicalrecord);
        if (saveMedicalRecordList != null){
            logger.info("POST createMedicalRecord SUCCESS");
        } else {
            logger.info("POST createMedicalRecord FAILED");
        }
        return saveMedicalRecordList;
    }

    @PutMapping("/medicalrecord/{firstNameLastName}")
    public Medicalrecord updateMedicalrecord(@RequestBody Medicalrecord medicalrecord, @PathVariable String firstNameLastName){
        Medicalrecord updateMedicalrecordOutput = medicalrecordServiceInterface.updateMedicalrecord(firstNameLastName, medicalrecord);
        if (updateMedicalrecordOutput != null){
            logger.info("PUT updateMedicalrecord SUCCESS");
        } else {
            logger.info("PUT updateMedicalrecord FAILED");
        }
        return updateMedicalrecordOutput;
    }


    @DeleteMapping("/medicalrecord/{firstNameLastName}")
    List<Medicalrecord> deleteMedicalrecord(@PathVariable String firstNameLastName){
        logger.info("DELETE deleteMedicalrecord SUCCESS");
        return medicalrecordServiceInterface.deleteMedicalrecord(firstNameLastName);
    }
}
