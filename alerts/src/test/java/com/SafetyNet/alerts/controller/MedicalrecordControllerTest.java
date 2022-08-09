package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.model.Medicalrecord;
import com.SafetyNet.alerts.service.MedicalrecordService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MedicalrecordController.class)
public class MedicalrecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicalrecordService medicalrecordService;

    @Test
    @DisplayName("Test findMedicalrecordAllTest")
    public void findMedicalrecordAllTest() throws Exception {
        Medicalrecord medicalrecord = new Medicalrecord();
        List<String> medications   = new ArrayList<String>();
        medications.add("hydroxycloroquine");
        medications.add("ivermectine");
        List<String> allergies = new LinkedList<String>();
        allergies.add("covid");
        allergies.add("grippe");
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();
        medicalrecord.setFirstName("karl");
        medicalrecord.setLastName("gavillot");
        medicalrecord.setBirthdate("08/30/1979");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);
        medicalrecordList.add(medicalrecord);
        when(medicalrecordService.findMedicalRecordAll()).thenReturn(medicalrecordList);

        mockMvc.perform(get("/medicalrecords")).andExpect(status().isOk());

        verify(medicalrecordService, times(1)).findMedicalRecordAll();
    }

    @Test
    @DisplayName("Test createMedicalRecordTest")
    public void createMedicalRecordTest() throws Exception {
        Medicalrecord medicalrecord = new Medicalrecord();
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();
        when(medicalrecordService.createMedicalrecord(any(Medicalrecord.class))).thenReturn(medicalrecordList);

        mockMvc.perform(post("/medicalrecord").content("{ \"firstName\":\"karl\", \"lastName\":\"gavillot\", \"birthdate\":\"08/30/1979\", \"medications\":[\"hydroxycloroquine: 200mg\", \"ivermectine:100mg\"], \"allergies\":[\"covid\", \"grippe\"] }").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        verify(medicalrecordService, times(1)).createMedicalrecord(any(Medicalrecord.class));
    }

    @Test
    @DisplayName("Test updateMedicalrecord")
    public void updateMedicalrecordTest() throws Exception {
        Medicalrecord medicalrecord = new Medicalrecord();
        List<String>  medications   = new ArrayList<String>();
        medications.add("aspirine");
        medications.add("cortisone");
        List<String> allergies = new ArrayList<String>();
        allergies.add("covid");
        allergies.add("grippe");
        medicalrecord.setFirstName("karl");
        medicalrecord.setLastName("gavillot");
        medicalrecord.setBirthdate("10/07/1980");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);
        when(medicalrecordService.updateMedicalrecord(any(String.class), (any(Medicalrecord.class)))).thenReturn(medicalrecord);

        mockMvc.perform(put("/medicalrecord/karlgavillot").content("{\"firstName\":\"karl\"}").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        verify(medicalrecordService, times(1)).updateMedicalrecord(any(String.class), (any(Medicalrecord.class)));
    }

    @Test
    @DisplayName("Test deleteMedicalrecordTest")
    public void deleteMedicalrecordTest() throws Exception {
        mockMvc.perform(delete("/medicalrecord/JohnBoyd")).andExpect(status().isOk());

        verify(medicalrecordService, times(1)).deleteMedicalrecord(any(String.class));

    }
}
