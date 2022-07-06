package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.model.Medicalrecord;
import com.SafetyNet.alerts.repository.MedicalrecordRepositoryInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalrecordService implements MedicalrecordServiceInterface{

    Logger logger = LoggerFactory.getLogger(MedicalrecordService.class);

    @Autowired
    MedicalrecordRepositoryInterface medicalrecordRepositoryInterface;

    public MedicalrecordService(MedicalrecordRepositoryInterface medicalrecordRepositoryInterface) {
        this.medicalrecordRepositoryInterface = medicalrecordRepositoryInterface;
    }

    public MedicalrecordRepositoryInterface getMedicalrecordRepositoryInterface() {
        return medicalrecordRepositoryInterface;
    }

    public void setMedicalrecordRepositoryInterface(MedicalrecordRepositoryInterface medicalrecordRepositoryInterface) {
        this.medicalrecordRepositoryInterface = medicalrecordRepositoryInterface;
    }

    @Override
    public List<Medicalrecord> findMedicalRecordAll() {
        logger.info("GET all Medicalrecord SUCCESS :");
        return medicalrecordRepositoryInterface.findMedicalRecordAll();
    }

    @Override
    public List<Medicalrecord> createMedicalrecord(Medicalrecord medicalrecord) {
        logger.info("Create Medicalrecord SUCCESS :" + medicalrecord);
        medicalrecordRepositoryInterface.createMedicalrecord(medicalrecord);
        return medicalrecordRepositoryInterface.findMedicalRecordAll();
    }

    @Override
    public Medicalrecord updateMedicalrecord(String firstNameLastName, Medicalrecord medicalrecord) {
        logger.info("Update Medicalrecord SUCCESS :" + medicalrecord);
        return medicalrecordRepositoryInterface.updateMedicalrecord(firstNameLastName, medicalrecord);
    }

    // URL Endpoint
    @Override
    public Medicalrecord findByFirstName(String firstName) {
        //logger.info("findByFirstName SUCCESS");
        return medicalrecordRepositoryInterface.findByFirstName(firstName);
    }


}
