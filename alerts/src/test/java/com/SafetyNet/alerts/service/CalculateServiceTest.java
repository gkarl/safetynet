package com.SafetyNet.alerts.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {

    MedicalrecordServiceInterface medicalrecordServiceInterface;

    private CalculeService calculeService = new CalculeService();

    @Test
    @DisplayName("Test calcule type adult children")
    public void calculateNumberTest(){

        String birthdayChild    = "03/06/2017";
        String birthdayAdult = "04/06/1965";

        calculeService.calculateAge(birthdayChild);
        calculeService.calculateAge(birthdayAdult);
        long children = calculeService.getChildren();
        long adults = calculeService.getAdults();


        //THEN
        assertEquals(children, 1);
        assertEquals(adults, 1);

    }

}
