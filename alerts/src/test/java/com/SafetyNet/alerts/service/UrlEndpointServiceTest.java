package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.dto.url2childAlert.PersonsWithAge;
import com.SafetyNet.alerts.dto.url4fire.PersonFireAddress;
import com.SafetyNet.alerts.dto.url5flood.FamilyListByStation;
import com.SafetyNet.alerts.dto.url6personInfo.PersonInfoDto;
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
    public void allPersonByStationTest() throws ParseException {
        listPersons = new ArrayList<Person>();
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
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
        person.setCity("boulogne");
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

    // URL 3
    @Test
    @DisplayName("Test phonesByFirestation")
    public void phonesByFirestationTest() throws ParseException{
        listPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
        person.setZip("92100");
        person.setPhone("0677777777");
        person.setEmail("karl@gmail.com");
        listPersons.add(person);

        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("voltaire");
        firestation.setStation(7);
        firestationList.add(firestation);

        when(personRepositoryInterface.findByAddress("voltaire")).thenReturn(listPersons);
        when(firestationRepositoryInterface.findAddressByStation(7)).thenReturn(firestationList);

        assertThat(urlEndpointService.phonesByFirestation(7).getListPhones().toString(), containsString("0677777777"));
    }

    //URL 4
    @Test
    @DisplayName("Test personsByAddress")
    public void personsByAddressTest() throws ParseException{
        listPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
        person.setZip("92100");
        person.setPhone("0677777777");
        person.setEmail("karl@gmail.com");
        listPersons.add(person);

        Firestation firestation = new Firestation();
        firestation.setAddress("voltaire");
        firestation.setStation(7);

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

        when(personRepositoryInterface.findByAddress("voltaire")).thenReturn(listPersons);
        when(medicalrecordRepositoryInterface.findByFirstName("karl")).thenReturn(medicalrecord);
        when(firestationRepositoryInterface.findById("voltaire")).thenReturn(firestation);

        for (PersonFireAddress personFireAddress : urlEndpointService.personsByAddress("voltaire").getListPersonsByAddress()){
            assertThat(personFireAddress.getLastName().toString(), containsString("gavillot"));
        }
    }

    // URL 5
    @Test
    @DisplayName("Test familyByFirestation")
    public void familyByFirestationTest() throws ParseException{
        listPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
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

        List<Integer> stations = new ArrayList<>();
        stations.add(1);
        stations.add(2);

        when(personRepositoryInterface.findByAddress("voltaire")).thenReturn(listPersons);
        when(medicalrecordRepositoryInterface.findByFirstName(person.getFirstName())).thenReturn(medicalrecord);
        when(firestationRepositoryInterface.findAddressByStation(any(int.class))).thenReturn(firestationList);

        List<FamilyListByStation> familyListByStationList = urlEndpointService.familyByStation(stations);
        for (FamilyListByStation familyListByStation : familyListByStationList){
            assertThat(familyListByStation.getLastName(), containsString("gavillot"));
        }
    }

    // URL 6
    @Test
    @DisplayName("Test personInfo")
    public void personInfoTest() throws ParseException{
        listPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
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

        when(personRepositoryInterface.findByFirstNameLastName("karl", "gavillot")).thenReturn(listPersons);
        when(medicalrecordRepositoryInterface.findByFirstName(person.getFirstName())).thenReturn(medicalrecord);

        for (PersonInfoDto personInfoDto : urlEndpointService.personsInfo("karl", "gavillot")){
            assertThat(personInfoDto.getLastName(), containsString("gavillot"));
            assertThat(personInfoDto.getEmail(), containsString("karl@gmail.com"));
            assertThat(personInfoDto.getMedications().toString(), containsString(medications.toString()));
            assertThat(personInfoDto.getAllergies().toString(), containsString(allergies.toString()));
        }
    }

    // URL 7
    @Test
    @DisplayName("Test emailsByCity")
    public void emailsByCityTest() throws ParseException {
        listPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("karl");
        person.setLastName("gavillot");
        person.setAddress("voltaire");
        person.setCity("boulogne");
        person.setZip("92100");
        person.setPhone("0677777777");
        person.setEmail("karl@gmail.com");
        listPersons.add(person);

        when(personRepositoryInterface.findEmailByCity("boulogne")).thenReturn(listPersons);

        assertThat(urlEndpointService.emailsByCity("boulogne").getListEmails().toString(), containsString("karl@gmail.com"));
    }

}
