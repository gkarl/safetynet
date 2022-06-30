package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.dto.url1firestation.PersonsByStationDto;
import com.SafetyNet.alerts.service.UrlEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlEndpointsController {

    @Autowired
    UrlEndpointService urlEndpointService;

    // URL 1 persons by firestation
    @GetMapping("/firestation")
    public PersonsByStationDto allPersonByStation(@RequestParam(value = "stationNumber") int stationNumber){
        return urlEndpointService.allPersonsByStation(stationNumber);
    }
}
