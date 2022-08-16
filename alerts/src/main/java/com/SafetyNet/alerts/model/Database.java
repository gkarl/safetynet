package com.SafetyNet.alerts.model;

import com.SafetyNet.alerts.controller.UrlEndpointsController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class Database {


    private List<Person> persons;
    private List<Medicalrecord> medicalrecords;
    private List<Firestation> firestations;

    @PostConstruct
    public void initDatabase() {
        Logger logger = LoggerFactory.getLogger(UrlEndpointsController.class);

        Database database = new Database();
        try {
            ObjectMapper objectMapper = new ObjectMapper();;
            database  = objectMapper.readValue(new File("src/main/resources/data.json"), Database.class);
        } catch (IOException e) {
            logger.error("Error database Get json file into POJO", e);
        }

        this.persons = database.getPersons();
        this.medicalrecords = database.getMedicalrecords();
        this.firestations = database.getFirestations();
    }

    public List<Person> getPersons() {

        return persons;
    }

    public List<Medicalrecord> getMedicalrecords() {

        return medicalrecords;
    }

    public List<Firestation> getFirestations() {

        return firestations;
    }


 /*   @Override
    public String toString() {

        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Person=" + "\n" + getPersons() + "\n");
        return stringbuilder.toString();
    }*/

}
