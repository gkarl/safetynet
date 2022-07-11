package com.SafetyNet.alerts.repository;


import com.SafetyNet.alerts.model.Database;
import com.SafetyNet.alerts.model.Medicalrecord;
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
public class MedicalrecordRepositoryTest {

    @Mock
    private Database database;

    @InjectMocks
    private MedicalrecordRepository medicalrecordRepository;

    @Test
    @DisplayName("Test FindMedicalRecordAll")
    public  void findMedicalRecordAllTest(){
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();

        when(database.getMedicalrecords()).thenReturn(medicalrecordList);
        List<Medicalrecord> findMedicalrecordAll = medicalrecordRepository.findMedicalRecordAll();

        Assertions.assertSame(medicalrecordList, findMedicalrecordAll);
        Assertions.assertTrue(findMedicalrecordAll.isEmpty());
        verify(database).getMedicalrecords();
    }

    @Test
    @DisplayName("Test createMedicalrecord")
    public  void createMedicalrecordTest(){
        List<Medicalrecord> medicalrecordList= new ArrayList<Medicalrecord>();

        //mock simulation
        when(database.getMedicalrecords()).thenReturn(medicalrecordList);

        List<Medicalrecord> createMedicalrecord = medicalrecordRepository.createMedicalrecord(new Medicalrecord());

        // AssertJ test
        assertSame(medicalrecordList, createMedicalrecord);
        assertEquals(1, createMedicalrecord.size());

        verify(database).getMedicalrecords();
        assertSame(createMedicalrecord, medicalrecordRepository.findMedicalRecordAll());
    }

    @Test
    @DisplayName("Test updateMedicalrecord")
    public void updateMedicalrecordTest(){
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();

        //mock simulation
        when(database.getMedicalrecords()).thenReturn(medicalrecordList);

        // AssertJ test
        assertNull(medicalrecordRepository.updateMedicalrecord("karl", new Medicalrecord()));

        verify(database).getMedicalrecords();
        assertSame(medicalrecordList, medicalrecordRepository.findMedicalRecordAll());

    }

    @Test
    @DisplayName("Test deleteMedicalrecord")
    public void deleteMedicalrecordTest(){
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();

        //mock simulation
        when(database.getMedicalrecords()).thenReturn(medicalrecordList);

        medicalrecordRepository.deleteMedicalrecord("Karl");
        verify(database).getMedicalrecords();
        List<Medicalrecord> getMedicalrecords = medicalrecordRepository.findMedicalRecordAll();

        // AssertJ test
        assertSame(medicalrecordList, getMedicalrecords);
        assertTrue(getMedicalrecords.isEmpty());
    }

    @Test
    @DisplayName("Test FindByFirstName")
    public void findByFirstNameTest(){
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();

        when(database.getMedicalrecords()).thenReturn(medicalrecordList);

        assertNull(medicalrecordRepository.findByFirstName("Karl"));
        verify(database).getMedicalrecords();
        assertSame(medicalrecordList, medicalrecordRepository.findMedicalRecordAll());
    }
}

