package com.SafetyNet.alerts.repository;

import com.SafetyNet.alerts.model.Database;
import com.SafetyNet.alerts.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonRepositoryTest {

    @Mock
    private Database database;

    // creates an instance of the class and injects the mocks
    @InjectMocks
    private PersonRepository personRepository;

    @Test
    @DisplayName("Test findPersonAll")
    public void findPersonAllTest(){
        List<Person> personList = new ArrayList<Person>();

        //mock simulation
        when(database.getPersons()).thenReturn(personList);

        List<Person> findPersonAll = personRepository.findPersonAll();

        // AssertJ test
        assertSame(personList, findPersonAll);
        assertTrue(findPersonAll.isEmpty());
        // Verify getPersons() call the good argument
        verify(database).getPersons();
    }

    @Test
    @DisplayName("Test createPerson")
    public void createPersonTest(){
        List<Person> personList = new ArrayList<Person>();

        //mock simulation
        when(database.getPersons()).thenReturn(personList);

        List<Person> savePersonList = personRepository.createPerson(new Person());

        assertSame(personList, savePersonList);
        assertEquals(1, savePersonList.size());
        // Verify getPersons() call the good argument
        verify(database).getPersons();
        assertSame(savePersonList, personRepository.findPersonAll());
    }

    @Test
    @DisplayName("Test updatePerson")
    public void updatePersonTest(){
        List<Person> personList = new ArrayList<Person>();

        //mock simulation
        when(database.getPersons()).thenReturn(personList);
        assertNull(personRepository.updatePerson("Karl", new Person()));
        // Verify getPersons() call the good argument
        verify(database).getPersons();
        assertSame(personList, personRepository.findPersonAll());
    }

    @Test
    @DisplayName("Test deletePerson")
    public void deletePersonTest(){
        List<Person> personList = new ArrayList<Person>();

        //mock simulation
        when(database.getPersons()).thenReturn(personList);

        personRepository.deletePerson("Karl");
        verify(database).getPersons();
        List<Person> getPersons = personRepository.findPersonAll();

        // AssertJ test
        assertSame(personList, getPersons);
        assertTrue(getPersons.isEmpty());

    }

    @Test
    @DisplayName("Test findByAddress")
    public void findByAddressTest(){
        List<Person> personList = new ArrayList<Person>();

        //mock simulation
        when(database.getPersons()).thenReturn(personList);
        assertTrue(personRepository.findByAddress("8 Downing Ct").isEmpty());

        // Verify getPersons() call the good argument
        verify(database).getPersons();
        Assertions.assertSame(personList, personRepository.findPersonAll());
    }
}
