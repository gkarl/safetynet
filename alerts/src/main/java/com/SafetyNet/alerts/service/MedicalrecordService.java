package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.model.Medicalrecord;
import com.SafetyNet.alerts.repository.MedicalrecordRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalrecordService implements MedicalrecordServiceInterface{

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
        return medicalrecordRepositoryInterface.findMedicalRecordAll();
    }

    @Override
    public List<Medicalrecord> createMedicalrecord(Medicalrecord medicalrecord) {
        medicalrecordRepositoryInterface.createMedicalrecord(medicalrecord);
        return medicalrecordRepositoryInterface.findMedicalRecordAll();
    }

    // URL Endpoint
    @Override
    public Medicalrecord findByFirstName(String firstName) {
        return medicalrecordRepositoryInterface.findByFirstName(firstName);
    }


}
