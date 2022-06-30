package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.repository.PersonRepositoryInterface;

import java.util.List;

public interface PersonServiceInterface {
    void setPersonRepositoryInterface(PersonRepositoryInterface personRepositoryInterface);

    List<Person> findPersonAll();

    List<Person> createPerson(Person person);

    // URL Endpoint
    List<Person> findByAddress(String address);
}
