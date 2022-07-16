package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.dto.url1firestation.PersonsByStationDto;
import com.SafetyNet.alerts.dto.url2childAlert.ChildByAddressDto;
import com.SafetyNet.alerts.dto.url2childAlert.PersonsWithAge;
import com.SafetyNet.alerts.dto.url3phoneAlert.PhoneAlertListDto;
import com.SafetyNet.alerts.dto.url4fire.PersonFireAddress;
import com.SafetyNet.alerts.dto.url4fire.PersonListByAddress;
import com.SafetyNet.alerts.model.Firestation;
import com.SafetyNet.alerts.model.Medicalrecord;
import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.repository.FirestationRepositoryInterface;
import com.SafetyNet.alerts.repository.MedicalrecordRepositoryInterface;
import com.SafetyNet.alerts.repository.PersonRepositoryInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UrlEndpointService {

    Logger logger = LoggerFactory.getLogger(UrlEndpointService.class);

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
        logger.info("GET allPersonsByStation SUCCESS");
        return new PersonsByStationDto(listPersonsStation, calculeService.getAdults(), calculeService.getChildren());
    }


    // URL 2 childs by address
    public ChildByAddressDto childsByAddress(String address) throws ParseException {
        List<Person> listPersonsByAddress = personRepositoryInterface.findByAddress(address);
        ChildByAddressDto childByAddressDto = new ChildByAddressDto();
        List<PersonsWithAge> childsList = new ArrayList<PersonsWithAge>();
        List<PersonsWithAge> adultsList = new ArrayList<PersonsWithAge>();
        CalculeService calculeService = new CalculeService();
        List<Medicalrecord> listMedicalrecords = new ArrayList<Medicalrecord>();
        for(Person person : listPersonsByAddress){
            Medicalrecord medicalrecord = medicalrecordRepositoryInterface.findByFirstName(person.getFirstName());
            listMedicalrecords.add(medicalrecord);
            calculeService.calculateAge(medicalrecord.getBirthdate());
            PersonsWithAge personsWithAge = new PersonsWithAge(person.getFirstName(), person.getLastName(), calculeService.getAge());
            if (calculeService.getAge() == 0){
                return null;
            } else {
                if (personsWithAge.getAge() < 18 ){
                    childsList.add(personsWithAge);
                } else {
                    adultsList.add(personsWithAge);
                }
            }
        }
        childByAddressDto.setChildren(childsList);
        childByAddressDto.setAdults(adultsList);
        logger.info("childsByAddress SUCCESS" + address);
        return childByAddressDto;
    }

    // URL 3 Phones by Firestation
    public PhoneAlertListDto phonesByFirestation(int firestation){
        List<Person> listPersons = new ArrayList<>();
        List<String> listPhones  = new ArrayList<>();
        for (Firestation firestationB : firestationRepositoryInterface.findAddressByStation(firestation)) {
            listPersons.addAll(personRepositoryInterface.findByAddress(firestationB.getAddress()));
        }
        for (Person person : listPersons) {
            listPhones.add(person.getPhone());
        }
        logger.info("phonesByFirestation SUCCESS :" + firestation);
        return new PhoneAlertListDto(listPhones);
    }

    // URL 4 fire
    public PersonListByAddress personsByAddress(String address) throws ParseException{
        Firestation firestationNumber = firestationRepositoryInterface.findById(address);

        if (firestationNumber != null){
            List<Person> listPersonsC = personRepositoryInterface.findByAddress(firestationNumber.getAddress());
            List<Person> listPersons = new ArrayList<>(listPersonsC);
            List<PersonFireAddress> listPersonByAddress = new ArrayList<>();
            CalculeService calculeService = new CalculeService();
            for (Person person : listPersons){
                Medicalrecord medicalrecord = medicalrecordRepositoryInterface.findByFirstName(person.getFirstName());
                calculeService.calculateAge(medicalrecord.getBirthdate());
                listPersonByAddress.add(new PersonFireAddress(person.getLastName(), person.getPhone(), calculeService.getAge(), medicalrecord.getMedications(), medicalrecord.getAllergies()));
            }
            logger.info("personsByAddress SUCCESS :" + address);
            return new PersonListByAddress(firestationNumber, listPersonByAddress);
        }
        else {
            return null;
        }
    }

}
