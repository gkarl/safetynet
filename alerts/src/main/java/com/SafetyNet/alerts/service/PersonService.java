package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.model.Database;
import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.repository.PersonRepositoryInterface;
import com.SafetyNet.alerts.service.PersonServiceInterface;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService implements PersonServiceInterface {

    Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    public PersonRepositoryInterface personRepositoryInterface;

    public PersonService(PersonRepositoryInterface personRepositoryInterface) {
        this.personRepositoryInterface = personRepositoryInterface;
    }

    public PersonRepositoryInterface getPersonRepositoryInterface() {
        return personRepositoryInterface;
    }

    public void setPersonRepositoryInterface(PersonRepositoryInterface personRepositoryInterface) {
        this.personRepositoryInterface = personRepositoryInterface;
    }


    @Override
    public List<Person> findPersonAll() {
        logger.info("GET all Persons SUCCESS");
        return personRepositoryInterface.findPersonAll();
    }

    @Override
    public List<Person> createPerson(Person person) {
        logger.info("Create Person SUCCESS :" + person);
        personRepositoryInterface.createPerson(person);
        return personRepositoryInterface.findPersonAll();
    }

    @Override
    public Person updatePerson(String firstNameAndLastName, Person person) {
        logger.info("Update Person SUCCESS:" + person);
        return personRepositoryInterface.updatePerson(firstNameAndLastName, person);
    }


    //URL Endpoint
    @Override
    public List<Person> findByAddress(String address) {
        //logger.info("findByAddress SUCCESS :" + address);
        return personRepositoryInterface.findByAddress(address);
    }

}
