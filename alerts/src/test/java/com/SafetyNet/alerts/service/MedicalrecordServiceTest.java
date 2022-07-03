package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.model.Medicalrecord;
import com.SafetyNet.alerts.repository.MedicalrecordRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


@ExtendWith(MockitoExtension.class)
public class MedicalrecordServiceTest {

    private MedicalrecordService medicalrecordService;

    @Mock
    private MedicalrecordRepositoryInterface medicalrecordRepositoryInterface;

    @BeforeEach
    public void setUp() throws Exception{
        medicalrecordService = new MedicalrecordService(medicalrecordRepositoryInterface);
    }

    @Test
    @DisplayName("Test findMedicalRecordAll")
    public void findMedicalRecordAllTest(){
        Medicalrecord medicalrecord = new Medicalrecord();
        List<String> medications = new ArrayList<>();
        medications.add("hydroxycloroquine");
        medications.add("ivermectine");
        List<String> allergies = new LinkedList<>();
        allergies.add("covid");
        allergies.add("grippe");
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();
        medicalrecord.setFirstName("karl");
        medicalrecord.setLastName("gavillot");
        medicalrecord.setBirthdate("16/02/1999");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);
        medicalrecordList.add(medicalrecord);

        when(medicalrecordRepositoryInterface.findMedicalRecordAll()).thenReturn(medicalrecordList);

        assertThat(medicalrecordService.findMedicalRecordAll().toString(), containsString("karl"));
    }

    @Test
    @DisplayName("Test createMedicalrecord")
    public void createMedicalrecordTest(){
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();
        Medicalrecord medicalrecord = new Medicalrecord();
        List<String> mediactions = new ArrayList<>();
        mediactions.add("hydroxycloroquine");
        mediactions.add("ivermectine");
        List<String> allergies = new LinkedList<>();
        allergies.add("covid");
        allergies.add("grippe");
        medicalrecord.setFirstName("karl");
        medicalrecord.setLastName("gavillot");
        medicalrecord.setBirthdate("16/02/1999");
        medicalrecord.setMedications(mediactions);
        medicalrecord.setAllergies(allergies);
        medicalrecordList.add(medicalrecord);

        //mock simulation
        when(medicalrecordRepositoryInterface.findMedicalRecordAll()).thenReturn(medicalrecordList);

        // AssertJ test
        assertThat(medicalrecordService.findMedicalRecordAll().toString(), containsString("karl"));
    }

    @Test
    @DisplayName("Test updateMedicalrecord")
    public void updateMedicalrecordTest(){
        Medicalrecord medicalrecord = new Medicalrecord();
        List<String> mediactions = new ArrayList<>();
        mediactions.add("hydroxycloroquine");
        mediactions.add("ivermectine");
        List<String> allergies = new LinkedList<>();
        allergies.add("covid");
        allergies.add("grippe");
        medicalrecord.setFirstName("karl");
        medicalrecord.setLastName("gavillot");
        medicalrecord.setBirthdate("16/02/1999");
        medicalrecord.setMedications(mediactions);
        medicalrecord.setAllergies(allergies);

        //mock simulation
        when(medicalrecordRepositoryInterface.updateMedicalrecord("karlgavillot", medicalrecord)).thenReturn((medicalrecord));

        // AssertJ test
        assertThat(medicalrecordService.updateMedicalrecord("karlgavillot", medicalrecord).toString(), containsString("karl"));

    }

    @Test
    @DisplayName("Test findBysFirstName")
    public void findByFirstNameTest(){
        Medicalrecord medicalrecord = new Medicalrecord();
        List<String> medications = new ArrayList<>();
        medications.add("hydroxycloroquine");
        medications.add("ivermectine");
        List<String> allergies = new LinkedList<>();
        allergies.add("covid");
        allergies.add("grippe");
        medicalrecord.setFirstName("karl");
        medicalrecord.setLastName("gavillot");
        medicalrecord.setBirthdate("16/02/1999");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);

        when(medicalrecordRepositoryInterface.findByFirstName("karl")).thenReturn(medicalrecord);

        assertThat(medicalrecordRepositoryInterface.findByFirstName("karl").toString(), containsString("karl"));
    }


}
