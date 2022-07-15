package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.dto.url2childAlert.PersonsWithAge;
import com.SafetyNet.alerts.model.Firestation;
import com.SafetyNet.alerts.model.Medicalrecord;
import com.SafetyNet.alerts.model.Person;
import com.SafetyNet.alerts.repository.FirestationRepositoryInterface;
import com.SafetyNet.alerts.repository.MedicalrecordRepositoryInterface;
import com.SafetyNet.alerts.repository.PersonRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UrlEndpointServiceTest {

    @Mock
    private static PersonRepositoryInterface personRepositoryInterface;

    @Mock
    private static FirestationRepositoryInterface firestationRepositoryInterface;

    @Mock
    private static MedicalrecordRepositoryInterface medicalrecordRepositoryInterface;

    @Mock
    private CalculeService calculeService = new CalculeService();

    @InjectMocks
    private static UrlEndpointService urlEndpointService;

    List<Person> listPersons;

    @BeforeEach
    void setUp() {
        urlEndpointService = new UrlEndpointService(personRepositoryInterface, firestationRepositoryInterface, medicalrecordRepositoryInterface);
    }

    //URL 1
    @Test
    @DisplayName("Test allPersonByStation")
    public void allPersonByStationTest() {
        listPersons = new ArrayList<Person>();
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setZip("92100");
        person.setPhone("0677777777");
        person.setEmail("karl@gmail.com");
        listPersons.add(person);

        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("voltaire");
        firestation.setStation(7);
        firestationList.add(firestation);

        Medicalrecord medicalrecord = new Medicalrecord();
        List<String> medications = new ArrayList<>();
        medications.add("hydroxycloroquine");
        medications.add("ivermectine");
        List<String> allergies = new ArrayList<>();
        allergies.add("covid");
        allergies.add("grippe");
        medicalrecord.setFirstName("karl");
        medicalrecord.setLastName("gavillot");
        medicalrecord.setBirthdate("08/30/1979");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);

        //WHEN
        when(personRepositoryInterface.findByAddress("voltaire")).thenReturn(listPersons);
        when(firestationRepositoryInterface.findAddressByStation(any(int.class))).thenReturn(firestationList);
        when(medicalrecordRepositoryInterface.findByFirstName(person.getFirstName())).thenReturn(medicalrecord);

        assertNotNull(urlEndpointService.allPersonsByStation(2));

        //THEN
        for (Person person1 : urlEndpointService.allPersonsByStation(2).getListPersonsStation()) {
            assertThat(person1.getFirstName(), containsString("karl"));

        }
    }

    //URL 2
    @Test
    @DisplayName("Test childsByAddress")
    public void childsByAddressTest() throws ParseException{
        listPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setZip("92100");
        person.setPhone("0677777777");
        person.setEmail("karl@gmail.com");
        listPersons.add(person);

        Medicalrecord medicalrecord = new Medicalrecord();
        List<String> medications = new ArrayList<>();
        medications.add("hydroxycloroquine");
        medications.add("ivermectine");
        List<String> allergies = new ArrayList<>();
        allergies.add("covid");
        allergies.add("grippe");
        medicalrecord.setFirstName("karl");
        medicalrecord.setLastName("gavillot");
        medicalrecord.setBirthdate("08/30/1979");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);

        when(personRepositoryInterface.findByAddress(any(String.class))).thenReturn(listPersons);
        when(medicalrecordRepositoryInterface.findByFirstName(any(String.class))).thenReturn(medicalrecord);

        for (PersonsWithAge childByAddressDto : urlEndpointService.childsByAddress("voltaire").getChildren()){
            assertThat(childByAddressDto.getFirstName(), containsString("karl"));
            assertThat(childByAddressDto.getLastName(), containsString("gavillot"));
        }
    }

}
