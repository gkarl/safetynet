package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.service.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PersonController {

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
        return newPersons;
    }


}
