package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.service.PersonService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;




@WebMvcTest(PersonController.class)
@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {

    @Autowired
    private PersonService personService;
}
