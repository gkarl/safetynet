package com.SafetyNet.alerts.model;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void initDatabase() throws IOException {

        Database database = new Database();
        try {
            // create object mapper
            ObjectMapper objectMapper = new ObjectMapper();
            // read JSON  file and map/convert to Java POJO:
            // Person thePersons  = objectMapper.readValue(new File("src/main/resources/data.json"), Person.class);
            database  = objectMapper.readValue(new File("src/main/resources/data.json"), Database.class);

           // System.out.println("First Name = " +  persons.getFirstName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.persons = database.getPersons();
        this.medicalrecords = database.getMedicalrecords();
        this.firestations = database.getFirestations();
        // print first name and last name
        //.System.out.println("First Name = " );
        //System.out.println("Last name = " );

        //System.out.println("Database Object\n" + database);
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
