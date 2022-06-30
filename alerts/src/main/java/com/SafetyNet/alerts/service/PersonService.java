package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.model.Database;
import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.repository.PersonRepositoryInterface;
import com.SafetyNet.alerts.service.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements PersonServiceInterface {

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
        return personRepositoryInterface.findPersonAll();
    }

    @Override
    public List<Person> createPerson(Person person) {
        personRepositoryInterface.createPerson(person);
        return personRepositoryInterface.findPersonAll();
    }


    //URL Endpoint
    @Override
    public List<Person> findByAddress(String address) {
        return personRepositoryInterface.findByAddress(address);
    }

}
