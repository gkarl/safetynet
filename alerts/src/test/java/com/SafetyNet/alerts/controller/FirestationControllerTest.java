package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.model.Firestation;
import com.SafetyNet.alerts.service.FirestationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

@WebMvcTest(FirestationController.class)
public class FirestationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Autowired
    private FirestationService firestationService;

    @Test
    @DisplayName("Test findFirestationAllTest")
    public void findFirestationAllTest() throws Exception {
        Firestation firestation = new Firestation();
        List<Firestation> firestationList = new ArrayList<>();
        firestation.setAddress("voltaire");
        firestation.setStation(7);
        firestationList.add(firestation);
        when(firestationService.findFirestationAll()).thenReturn(firestationList);

        mockMvc.perform(get("/firestations")).andExpect(status().isOk());

        verify(firestationService, times(1)).findFirestationAll();
    }

    @Test
    @DisplayName("Test createFirestationTest")
    public void createFirestationTest() throws Exception {
        Firestation firestation = new Firestation();
        List<Firestation> firestationList = new ArrayList<>();
        firestation.setAddress("voltaire");
        firestation.setStation(7);
        when(firestationService.createFirestation(any(Firestation.class))).thenReturn(firestationList);

        mockMvc.perform(post("/firestation").content("{ \"address\":\"voltaire\", \"station\":\"7\" }").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        verify(firestationService, times(1)).createFirestation(any(Firestation.class));
    }

    @Test
    @DisplayName("Test updateFirestationTest")
    public void updateFirestationTest() throws Exception {
        Firestation firestation = new Firestation();
        firestation.setAddress("voltaire");
        firestation.setStation(7);
        when(firestationService.updateFirestation(any(Firestation.class))).thenReturn(firestation);

        mockMvc.perform(put("/firestation").content("{ \"address\":\"voltaire\", \"station\":\"7\" }").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        verify(firestationService, times(1)).updateFirestation(any(Firestation.class));
    }

    @Test
    @DisplayName("Test deleteFirestationTest")
    public void deleteFirestationTest() throws Exception {
        mockMvc.perform(delete("/firestation/station")).andExpect(status().isOk());

        verify(firestationService, times(1)).deleteFirestation(any(String.class));
    }

}
