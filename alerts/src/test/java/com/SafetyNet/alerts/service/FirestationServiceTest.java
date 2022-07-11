package com.SafetyNet.alerts.service;

import com.SafetyNet.alerts.model.Firestation;
import com.SafetyNet.alerts.repository.FirestationRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FirestationServiceTest {

    private FirestationService firestationService;

    @Mock
    private FirestationRepositoryInterface firestationRepositoryInterface;

    @BeforeEach
    public void setUp(){
        firestationService = new FirestationService(firestationRepositoryInterface);
    }

    @Test
    @DisplayName("Test findFirestationAll")
    public void findFirestationTest(){
        Firestation firestation =new Firestation();
        firestation.setAddress("voltaire");
        firestation.setStation(16);
        List<Firestation> firestationList= new ArrayList<Firestation>();
        firestationList.add(firestation);

        when(firestationRepositoryInterface.findFirestationAll()).thenReturn(firestationList);

        assertThat(firestationService.findFirestationAll().toString(), containsString("voltaire"));
    }

    @Test
    @DisplayName("Test createFirestation")
    public void createFirestationTest(){

        List<Firestation> firestationList = new ArrayList<Firestation>();
        Firestation firestation = new Firestation();
        firestation.setAddress("voltaire");
        firestation.setStation(16);
        firestationList.add(firestation);

        //mock simulation
        when(firestationRepositoryInterface.createFirestation(firestation)).thenReturn(firestationList);

        // AssertJ test
        assertThat(firestationService.createFirestation(firestation).toString(), containsString("voltaire"));
    }

    @Test
    @DisplayName("Test updateFirestation")
    public void updateFirestationTest(){
        Firestation firestation = new Firestation();
        firestation.setAddress("voltaire");
        firestation.setStation(16);

        //mock simulation
        when(firestationRepositoryInterface.updateFirestation(firestation)).thenReturn(firestation);

        // AssertJ test
        assertThat(firestationService.updateFirestation(firestation).toString(), containsString("voltaire"));
    }

    @Test
    @DisplayName("Test deleteFirestation")
    public void deleteFirestationT(){
        List<Firestation> firestationList = new ArrayList<Firestation>();
        Firestation firestation = new Firestation();
        firestation.setAddress("voltaire");
        firestation.setStation(16);
        firestationList.add(firestation);

        when(firestationRepositoryInterface.findFirestationAll()).thenReturn(firestationList);

        assertThat(firestationService.findFirestationAll().toString(), containsString("voltaire"));

    }

    @Test
    @DisplayName("Test findAddressByStation")
    public void findAddressByStationTest(){
        Firestation firestation = new Firestation();
        firestation.setAddress("voltaire");
        firestation.setStation(16);
        List<Firestation> firestationList= new ArrayList<Firestation>();
        firestationList.add(firestation);

        when(firestationRepositoryInterface.findAddressByStation(16)).thenReturn(firestationList);

        assertThat(firestationService.findAddressByStation(16).toString(), containsString("16"));
    }
}
