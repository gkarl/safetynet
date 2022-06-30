package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.dto.url1firestation.PersonsByStationDto;
import com.SafetyNet.alerts.model.Firestation;
import com.SafetyNet.alerts.model.Medicalrecord;
import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.repository.FirestationRepositoryInterface;
import com.SafetyNet.alerts.repository.MedicalrecordRepositoryInterface;
import com.SafetyNet.alerts.repository.PersonRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrlEndpointService {

    @Autowired
    PersonRepositoryInterface personRepositoryInterface;

    public UrlEndpointService(PersonRepositoryInterface personRepositoryInterface, FirestationRepositoryInterface firestationRepositoryInterface, MedicalrecordRepositoryInterface medicalrecordRepositoryInterface) {
        this.personRepositoryInterface = personRepositoryInterface;
        this.firestationRepositoryInterface = firestationRepositoryInterface;
        this.medicalrecordRepositoryInterface = medicalrecordRepositoryInterface;
    }

    public PersonRepositoryInterface getPersonRepositoryInterface() {
        return personRepositoryInterface;
    }

    public void setPersonRepositoryInterface(PersonRepositoryInterface personRepositoryInterface) {
        this.personRepositoryInterface = personRepositoryInterface;
    }

    @Autowired
    FirestationRepositoryInterface firestationRepositoryInterface;

    public FirestationRepositoryInterface getFirestationRepositoryInterface() {
        return firestationRepositoryInterface;
    }

    public void setFirestationRepositoryInterface(FirestationRepositoryInterface firestationRepositoryInterface) {
        this.firestationRepositoryInterface = firestationRepositoryInterface;
    }

    @Autowired
    MedicalrecordRepositoryInterface medicalrecordRepositoryInterface;

    public MedicalrecordRepositoryInterface getMedicalrecordRepositoryInterface() {
        return medicalrecordRepositoryInterface;
    }

    public void setMedicalrecordRepositoryInterface(MedicalrecordRepositoryInterface medicalrecordRepositoryInterface) {
        this.medicalrecordRepositoryInterface = medicalrecordRepositoryInterface;
    }

    // URL 1 Address by firestation
    public PersonsByStationDto allPersonsByStation(int stationNumber){
        List<Person> listPersonsStation = new ArrayList<Person>();
        CalculeService calculeService = new CalculeService();
        for (Firestation firestation : firestationRepositoryInterface.findAddressByStation(stationNumber)){
            List<Person> listPerson = personRepositoryInterface.findByAddress(firestation.getAddress());
            listPersonsStation.addAll(listPerson);
            for (Person person : listPerson){
                Medicalrecord medicalrecord = medicalrecordRepositoryInterface.findByFirstName(person.getFirstName());
                calculeService.calculateAge(medicalrecord.getBirthdate());
            }
        }
        return new PersonsByStationDto(listPersonsStation, calculeService.getAdults(), calculeService.getChildren());
    }


}
