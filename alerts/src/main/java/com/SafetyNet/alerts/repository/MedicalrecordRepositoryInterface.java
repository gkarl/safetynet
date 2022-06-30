package com.SafetyNet.alerts.repository;

import com.SafetyNet.alerts.model.Medicalrecord;

import java.util.List;

public interface MedicalrecordRepositoryInterface {

    List<Medicalrecord> findMedicalRecordAll();

    List<Medicalrecord> createMedicalrecord(Medicalrecord medicalrecord);

    //URL Endpoint
    Medicalrecord findByFirstName(String firstName);
}