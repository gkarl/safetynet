package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.model.Medicalrecord;
import com.SafetyNet.alerts.repository.MedicalrecordRepositoryInterface;

import java.util.List;

public interface MedicalrecordServiceInterface {

    void setMedicalrecordRepositoryInterface(MedicalrecordRepositoryInterface medicalrecordRepositoryInterface);

    List<Medicalrecord> findMedicalRecordAll();

    List<Medicalrecord> createMedicalrecord(Medicalrecord medicalrecord);

    // URL Endpoint
    Medicalrecord findByFirstName(String firstName);
}
