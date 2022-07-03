package com.SafetyNet.alerts.repository;

import com.SafetyNet.alerts.model.Database;
import com.SafetyNet.alerts.model.Medicalrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalrecordRepository implements MedicalrecordRepositoryInterface{


   @Autowired
   private Database database;

    @Override
    public List<Medicalrecord> findMedicalRecordAll() {
        return database.getMedicalrecords();
    }

    @Override
    public List<Medicalrecord> createMedicalrecord(Medicalrecord medicalrecord) {
        List<Medicalrecord> saveMedicalrecordList = database.getMedicalrecords();
        saveMedicalrecordList.add(medicalrecord);
        return saveMedicalrecordList;
    }

    @Override
    public Medicalrecord updateMedicalrecord(String firstNameLastName, Medicalrecord medicalrecord) {
        List<Medicalrecord> updateMedicalrecordList = database.getMedicalrecords();
        for (Medicalrecord updateMedical : updateMedicalrecordList){
            if (updateMedical.getFirstNameLastName().equals(firstNameLastName)){
                updateMedical.setBirthdate(medicalrecord.getBirthdate());
                updateMedical.setMedications(medicalrecord.getMedications());
                updateMedical.setAllergies(medicalrecord.getAllergies());
                return updateMedical;
            }
        }
        return null;
    }

    //URL Endpoint
    @Override
    public Medicalrecord findByFirstName(String firstName) {
        for (Medicalrecord medicalrecord : database.getMedicalrecords()){
            if (medicalrecord.getFirstName().equals(firstName)){
                return medicalrecord;
            }
        }
        return null;
    }


}
