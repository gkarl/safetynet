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

    @Override
    public List<Person> createPerson(Person person) {
        List<Person> savePersonList = database.getPersons();
        savePersonList.add(person);
        return savePersonList;
    }

    @Override
    public Person updatePerson(String firstNameLastName, Person person) {
        List<Person> updatePersonList;
        updatePersonList = database.getPersons();
        for (Person update : updatePersonList) {
            if (update.getFirstNameLastName().equals(firstNameLastName)) {
                update.setAddress(person.getAddress());
                update.setCity(person.getCity());
                update.setZip(person.getZip());
                update.setPhone(person.getPhone());
                update.setEmail(person.getEmail());
                return update;
            }
        }
        return null;
    }

    @Override
    public void deletePerson(String firstNameLastName) {
        List<Person> personList = database.getPersons();
        personList.removeIf(person -> person.getFirstNameLastName().equals(firstNameLastName));
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

    @Override
    public List<Person> findByFirstNameLastName(String firstName, String lastName) {
        List<Person> listPerson = new ArrayList<Person>();
        for (Person person : database.getPersons()){
            if (person.getFirstName().equals(firstName) && (person.getLastName().equals(lastName))){
                listPerson.add(person);
            }
        }
        return listPerson;
    }

    @Override
    public List<Person> findEmailByCity(String city) {
        List<Person> listPerson = new ArrayList<>();
        for (Person person : database.getPersons()){
            if (person.getCity().equals(city)){
                listPerson.add(person);
            }
        }
        return listPerson;
    }


}
