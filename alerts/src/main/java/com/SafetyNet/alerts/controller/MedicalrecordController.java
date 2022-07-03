package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.model.Medicalrecord;
import com.SafetyNet.alerts.service.MedicalrecordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicalrecordController {

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

        return medicalrecordServiceInterface.findMedicalRecordAll();
    }

    @PostMapping("medicalrecord")
    List<Medicalrecord> createMedicalRecord(@RequestBody Medicalrecord medicalrecord){
        List<Medicalrecord> saveMedicalRecordList = medicalrecordServiceInterface.createMedicalrecord(medicalrecord);
        return saveMedicalRecordList;
    }

    @PutMapping("/medicalrecord/{firstNameLastName}")
    public Medicalrecord updateMedicalrecord(@RequestBody Medicalrecord medicalrecord, @PathVariable String firstNameLastName){
        Medicalrecord updateMedicalrecordOutput = medicalrecordServiceInterface.updateMedicalrecord(firstNameLastName, medicalrecord);
        return updateMedicalrecordOutput;
    }

}
