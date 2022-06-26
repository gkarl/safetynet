package com.SafetyNet.alerts.controller.personlist;

import com.SafetyNet.alerts.controller.PersonControllerInterface;
import com.SafetyNet.alerts.model.Database;
import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.service.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PersonController implements PersonControllerInterface {

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
        System.out.println("LA METHODE DISPLAY HOME PAGE A ETE INVOQUE");
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

  /*  @RequestMapping("/persons")
    public String displayHome(HttpServletRequest request){
        System.out.println("LA METHODE DISPLAY hOME A ETE INVOQUE");
        List<Person> persons = persons.getPersonsList();
        request.setAttribute("persons", persons);
    }*/
}
