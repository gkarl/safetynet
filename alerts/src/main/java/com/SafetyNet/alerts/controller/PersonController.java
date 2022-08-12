package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.service.PersonServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonServiceInterface personServiceInterface;

    public PersonServiceInterface getPersonServiceInterface() {
        return personServiceInterface;
    }

    public void setPersonServiceInterface(PersonServiceInterface personServiceInterface) {
        this.personServiceInterface = personServiceInterface;
    }

    @RequestMapping("/index")
    public String displayHome(){
        System.out.println("LA METHODE DISPLAYHOME A ETE INVOQUE lA HOME PAGE S AFFICHE");
        String persons = "Testons";
        /*request.setAttribute("persons", persons);*/
        return persons;
    }

    @GetMapping("/persons")
    public List<Person> findPersonAll() {
        List<Person> findPerson = personServiceInterface.findPersonAll();
        if (findPerson != null){
            logger.info("GET findPersonAll SUCCESS");
        } else {
            logger.info("GET findPersonAll FAILED");
        }
        return findPerson;
    }

    @GetMapping("/persons/N1")
    public Person findOnePerson() {
        Person findPerson = personServiceInterface.findPersonAll().get(0);
        return findPerson;
    }

    @PostMapping("/person")
    public List<Person> addPerson(@RequestBody Person person){
        List<Person> newPersons = personServiceInterface.createPerson(person);
        if (newPersons != null){
            logger.info("POST addPerson SUCCESS");
        } else {
            logger.error("POST addPerson FAILED");
        }
        return newPersons;
    }

    @PutMapping(value = "/person/{firstNameLastName}")
    public Person updatePerson(@RequestBody Person person, @PathVariable String firstNameLastName) {
        Person updatePersonOutput = personServiceInterface.updatePerson(firstNameLastName, person);
        if ( updatePersonOutput != null){
            logger.info("PUT updatePerson SUCCESS");
        } else {
            logger.error("PUT updatePerson FAILED");
        }
        return updatePersonOutput;
    }

    @DeleteMapping("/person/{firstNameLastName}")
    public List<Person> deletePerson(@PathVariable String firstNameLastName){
        logger.info("DELETE deletePerson SUCCESS");
        return personServiceInterface.deletePerson(firstNameLastName);
    }



}
