package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.repository.PersonRepositoryInterface;

import java.util.List;

public interface PersonServiceInterface {
    List<Person> findPersonAll();
    void setPersonRepositoryInterface(PersonRepositoryInterface personRepositoryInterface);
}
