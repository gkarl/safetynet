package com.SafetyNet.alerts.repository;

import com.SafetyNet.alerts.model.Database;
import com.SafetyNet.alerts.model.Firestation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertSame;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FirestationRepositoryTest {

    @Mock
    private Database database;

    // creates an instance of the class and injects the mocks
    @InjectMocks
    private FirestationRepository firestationRepository;

    @Test
    @DisplayName("Test findFirestationAll")
    public void findFirestationAllTest(){
        List<Firestation> firestationList = new ArrayList<Firestation>();
        //mock simulation
        when(database.getFirestations()).thenReturn(firestationList);

        List<Firestation> findFirestationAll = firestationRepository.findFirestationAll();
        // AssertJ test
        assertSame(firestationList, findFirestationAll);
        assertTrue(findFirestationAll.isEmpty());
        // Verify getPersons() call the good argument
        verify(database).getFirestations();
    }

    @Test
    @DisplayName("Test findAddresByStation")
    public void findAddressByStationTest(){
        List<Firestation> firestationList = new ArrayList<Firestation>();
        //mock simulation
        when(database.getFirestations()).thenReturn(firestationList);

        assertTrue(firestationRepository.findAddressByStation(20).isEmpty());
        verify(database).getFirestations();
        assertSame(firestationList, firestationRepository.findFirestationAll());
    }
}
