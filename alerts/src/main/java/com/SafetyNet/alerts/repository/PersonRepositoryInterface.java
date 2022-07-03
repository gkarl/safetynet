package com.SafetyNet.alerts.repository;

import com.SafetyNet.alerts.model.Person;

import java.util.List;

public interface PersonRepositoryInterface {

    List<Person> findPersonAll();

    List<Person> createPerson(Person person);

    Person updatePerson(String firstNameLastName, Person person);

    List<Person> findByAddress(String address);
}
