package com.SafetyNet.alerts.controller;

import com.SafetyNet.alerts.dto.url1firestation.PersonsByStationDto;
import com.SafetyNet.alerts.dto.url2childAlert.ChildByAddressDto;
import com.SafetyNet.alerts.dto.url3phoneAlert.PhoneAlertListDto;
import com.SafetyNet.alerts.dto.url4fire.PersonListByAddress;
import com.SafetyNet.alerts.dto.url5flood.FamilyListByStation;
import com.SafetyNet.alerts.dto.url6personInfo.PersonInfoDto;
import com.SafetyNet.alerts.service.UrlEndpointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        logger.info("GET allPersonByStation SUCCESS :");
        return urlEndpointService.allPersonsByStation(stationNumber);
    }

    // URL 2 child Alert
    @GetMapping("/childAlert")
    public ChildByAddressDto childsByAddress(@RequestParam("address") String address) throws ParseException{
        logger.info("GET childsByAddress SUCCESS :");
        return urlEndpointService.childsByAddress(address);
    }

    //URL 3 Phone Alert
    @GetMapping("/phoneAlert")
    public PhoneAlertListDto phonesByFirestation(@RequestParam(value = "firestation") int firestation){
        logger.info("GET phonesByFirestation SUCCESS :");
        return urlEndpointService.phonesByFirestation(firestation);
    }

    // URL 4 fire
    @GetMapping("/fire")
    public PersonListByAddress personsByAddress(@RequestParam("address") String address) throws ParseException{
        logger.info("GET personsByAddress SUCCESS :");
        return urlEndpointService.personsByAddress(address);
    }

    // URL 5 flood
    @GetMapping("flood/stations")
    public List<FamilyListByStation> familyByFirestation(@RequestParam(value = "stations") List<Integer> stations) throws ParseException{
        logger.info("GET familyByFirestation SUCCESS :");
        return urlEndpointService.familyByStation(stations);
    }

    // URL 6 personInfo
    @GetMapping(value = "/personInfo")
    public List<PersonInfoDto> personInfo(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) throws ParseException {
        logger.info("GET personsInfo SUCCESS");
        return urlEndpointService.personsInfo(firstName, lastName);
    }
}
