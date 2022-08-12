package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.dto.url1firestation.PersonsByStationDto;
import com.SafetyNet.alerts.dto.url2childAlert.ChildByAddressDto;
import com.SafetyNet.alerts.dto.url3phoneAlert.PhoneAlertListDto;
import com.SafetyNet.alerts.dto.url4fire.PersonListByAddress;
import com.SafetyNet.alerts.dto.url5flood.FamilyListByStation;
import com.SafetyNet.alerts.dto.url6personInfo.PersonInfoDto;
import com.SafetyNet.alerts.dto.url7communityEmail.EmailListDto;
import com.SafetyNet.alerts.exception.NotFoundException;
import com.SafetyNet.alerts.service.UrlEndpointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.util.List;

@RestController
public class UrlEndpointsController {

    Logger logger = LoggerFactory.getLogger(UrlEndpointsController.class);

    @Autowired
    UrlEndpointService urlEndpointService;

    // URL 1 persons by firestation
    @GetMapping("/firestation")
    public PersonsByStationDto allPersonByStation(@RequestParam(value = "stationNumber") int stationNumber) throws ParseException {
            PersonsByStationDto response = urlEndpointService.allPersonsByStation(stationNumber);
            logger.info(String.valueOf(response));
            return response;
    }

    // URL 2 child Alert
    @GetMapping("/childAlert")
    public ChildByAddressDto childsByAddress(@RequestParam("address") String address) throws ParseException{
        ChildByAddressDto response = urlEndpointService.childsByAddress(address);
        logger.info(String.valueOf(response));
        return response;
    }

    //URL 3 Phone Alert
    @GetMapping("/phoneAlert")
    public PhoneAlertListDto phonesByFirestation(@RequestParam(value = "firestation") int firestation) throws ParseException {
        PhoneAlertListDto response = urlEndpointService.phonesByFirestation(firestation);
        logger.info(String.valueOf(response));
        return response;
    }

    // URL 4 fire
    @GetMapping("/fire")
    public PersonListByAddress personsByAddress(@RequestParam("address") String address) throws ParseException{
        PersonListByAddress response = urlEndpointService.personsByAddress(address);
        logger.info(String.valueOf(response));
        return response;
    }

    // URL 5 flood
    @GetMapping("flood/stations")
    public List<FamilyListByStation> familyByFirestation(@RequestParam(value = "stations") List<Integer> stations) throws ParseException{
        List<FamilyListByStation> response = urlEndpointService.familyByStation(stations);
        logger.info(String.valueOf(response));
        return response;
    }

    // URL 6 personInfo
    @GetMapping(value = "/personInfo")
    public List<PersonInfoDto> personInfo(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) throws ParseException {
        List<PersonInfoDto> response = urlEndpointService.personsInfo(firstName, lastName);
        logger.info(String.valueOf(response));
        return response;
    }

    // URL 7 communityEmail
    @GetMapping("/communityEmail")
    public EmailListDto emailsByCity(@RequestParam(value = "city") String city) throws ParseException {
        EmailListDto response =  urlEndpointService.emailsByCity(city);
        logger.info(String.valueOf(response));
        return response;
    }
}
