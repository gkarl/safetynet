package com.SafetyNet.alerts;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.SafetyNet.alerts.controller.personlist", "com.SafetyNet.alerts.service.personslist", "com.SafetyNet.alerts.repository.database"})
@PropertySource("classpath:application.properties")
public class AppConfig {
}
