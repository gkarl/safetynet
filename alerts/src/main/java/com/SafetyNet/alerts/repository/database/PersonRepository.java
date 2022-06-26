package com.SafetyNet.alerts.repository.database;

import com.SafetyNet.alerts.model.Database;
import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.repository.PersonRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
