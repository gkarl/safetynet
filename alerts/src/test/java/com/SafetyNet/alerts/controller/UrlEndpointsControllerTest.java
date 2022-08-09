package com.SafetyNet.alerts.controller;


import com.SafetyNet.alerts.service.UrlEndpointService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UrlEndpointsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UrlEndpointService urlEndpointService;

    // URL 1
    @Test
    @DisplayName("Test allPersonsByStationStationNullTest")
    public void allPersonsByStationStationNullTest() throws Exception {
        mockMvc.perform(get("/firestation?stationNumber=")).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test allPersonsByStationTest")
    public void allPersonsByStationTest() throws Exception {
        mockMvc.perform(get("/firestation?stationNumber=1")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test allPersonsByStationStationErrorTest")
    public void allPersonsByStationStationErrorTest() throws Exception {
        mockMvc.perform(get("/firestation?stationNumber=ok ")).andExpect(status().isBadRequest());
    }

    // URL 2
    @Test
    @DisplayName("Test childsByAddressNullTest")
    public void childsByAddressNullTest() throws Exception {
        mockMvc.perform(get("/childAlert?address=")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test childsByAddressTest")
    public void childsByAddressTest() throws Exception {
        mockMvc.perform(get("/childAlert?address=1892 Downing Ct")).andExpect(status().isOk());
    }

    // URL 3
    @Test
    @DisplayName("Test phonesByFirestationErrorTest")
    public void phonesByFirestationErrorTest() throws Exception {
        mockMvc.perform(get("/phoneAlert?firestation=ok")).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test phonesByFirestationTest")
    public void phonesByFirestationTest() throws Exception {
        mockMvc.perform(get("/phoneAlert?firestation=1")).andExpect(status().isOk());
    }

    // URL 4
    @Test
    @DisplayName("Test personsByAddressTest")
    public void personsByAddressTest() throws Exception {
        mockMvc.perform(get("/fire?address=1509 Culver St")).andExpect(status().isOk());
    }

    // URL 5
    @Test
    @DisplayName("Test familyByFirestationTest")
    public void familyByFirestationTest() throws Exception {
        mockMvc.perform(get("/flood/stations?stations=3")).andExpect(status().isOk());
    }

    // URL 6
    @Test
    @DisplayName("Test personInfoNullTest")
    public void personInfoNullTest() throws Exception {
        mockMvc.perform(get("/personInfo?firstName=&lastname")).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test personInfo")
    public void personInfoTest() throws Exception {
        mockMvc.perform(get("/personInfo?firstName=Eric&lastName=Cadigan")).andExpect(status().isOk());
    }

    // URL 7
    @Test
    @DisplayName("Test emailsByCityTest")
    public void emailsByCityTest() throws Exception {
        mockMvc.perform(get("/communityEmail?city=Culver")).andExpect(status().isOk());
    }


}
