package com.SafetyNet.alerts.repository;

import com.SafetyNet.alerts.model.Database;
import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.repository.PersonRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository implements PersonRepositoryInterface {

    private List<Person> persons;
    @Autowired
    private Database database;

    @Override
    public List<Person> findPersonAll() {
        return database.getPersons();
    }

    // URL Endpoints

    @Override
    public List<Person> findByAddress(String address) {
        List<Person> listPerson = new ArrayList<Person>();
        for(Person person : database.getPersons()){
            if(person.getAddress().equals(address)){
                listPerson.add(person);
            }
        }
        return listPerson;
    }

}
