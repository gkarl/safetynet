package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.service.PersonServiceInterface;

import java.util.List;

public interface PersonControllerInterface {
    List<Person> findPersonAll();
    void setPersonServiceInterface(PersonServiceInterface personServiceInterface);
}
