package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PersonController.class)
@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {

    @MockBean
    @Autowired
    private PersonService personService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Test findPersonAllTest")
    public void findPersonAllTest() throws Exception {
        Person person      = new Person();
        List<Person> listPersons = new ArrayList<Person>();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
        person.setZip("92100");
        person.setPhone("0677777777");
        person.setEmail("karl@gmail.com");
        listPersons.add(person);

        when(personService.findPersonAll()).thenReturn(listPersons);

        mockMvc.perform(get("/persons")).andExpect(status().isOk());

        verify(personService, times(1)).findPersonAll();
    }

    @Test
    @DisplayName("Test addPersonTest")
    public void addPersonTest() throws Exception {
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
        person.setZip("92100");
        person.setPhone("0677777777");
        person.setEmail("karl@gmail.com");
        List<Person> listPerson = new ArrayList<Person>();
        listPerson.add(person);
        when(personService.createPerson(any(Person.class))).thenReturn(listPerson);

        mockMvc.perform(post("/person").content("{ \"firstName\":\"karl\", \"lastName\":\"gavillot\", \"address\":\"voltaire\", \"city\":\"boulogne\" }").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        verify(personService, times(1)).createPerson(any(Person.class));
    }

    @Test
    @DisplayName("Test updatePersonTest")
    public void updatePersonTest() throws Exception {
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
        person.setZip("92100");
        person.setPhone("0677777777");
        person.setEmail("karl@gmail.com");
        when(personService.updatePerson(any(String.class), (any(Person.class)))).thenReturn(person);

        mockMvc.perform(put("/person/KarlGavillot").content("{\"firstName\":\"karl\"}").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        verify(personService, times(1)).updatePerson(any(String.class), (any(Person.class)));
    }

    @Test
    @DisplayName("Test deletePersonTest")
    public void deletePersonTest() throws Exception {
        mockMvc.perform(delete("/person/JacobBoyd", 1)).andExpect(status().isOk());

        verify(personService, times(1)).deletePerson(any(String.class));
    }
}
