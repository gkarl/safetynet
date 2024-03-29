package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.repository.PersonRepository;
import com.SafetyNet.alerts.repository.PersonRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    private PersonService personService;

    @Mock
    private PersonRepositoryInterface personRepositoryInterface;


    @BeforeEach
    public void setUp() throws Exception{
        personService = new PersonService(personRepositoryInterface);
    }


    @Test
    @DisplayName("Test findPersonAll")
    public void findPersonAllTest(){
        List<Person> listPerson = new ArrayList<Person>();
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
        person.setZip("92100");
        person.setPhone("0677777777");
        person.setEmail("karl@gmail.com");
        listPerson.add(person);

        when(personRepositoryInterface.findPersonAll()).thenReturn(listPerson);

        assertThat(personService.findPersonAll().toString(), containsString("karl"));
    }

    @Test
    @DisplayName("Test createPerson")
    public void createPersonTest(){
        List<Person> personList = new ArrayList<Person>();
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
        person.setZip("92100");
        person.setPhone("0677777777");
        person.setEmail("karl@gmail.com");
        personList.add(person);

        //mock simulation
        when(personRepositoryInterface.findPersonAll()).thenReturn(personList);
        // AssertJ test
        assertThat(personService.createPerson(person).toString(), containsString("karl"));
    }

    @Test
    @DisplayName("Test updatePerson")
    public void updatePersonTest(){
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
        person.setZip("92100");
        person.setPhone("0677777777");
        person.setEmail("karl@gmail.com");

        //mock simulation
        when(personRepositoryInterface.updatePerson("karlgavillot", person)).thenReturn(person);

        // AssertJ test
        assertThat(personService.updatePerson("karlgavillot", person).toString(), containsString("karl"));

    }

    @Test
    @DisplayName("Test deletePerson")
    public void deletePersonTest(){
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
        person.setZip("92100");
        person.setPhone("0677777777");
        person.setEmail("karl@gmail.com");
        personService.createPerson(person);

        assertThat(personService.deletePerson("karlgavillot").toString(), containsString(""));

    }

    @Test
    @DisplayName("Test findByLastName")
    public void findByAddressTest(){
        List<Person> listPerson = new ArrayList<Person>();
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
        person.setZip("92100");
        person.setPhone("0677777777");
        person.setEmail("karl@gmail.com");
        listPerson.add(person);

        when(personRepositoryInterface.findByAddress("voltaire")).thenReturn(listPerson);
        assertThat(personService.findByAddress("voltaire").toString(), containsString("karl"));
    }

}
