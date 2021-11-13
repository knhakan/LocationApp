package com.uberall.demo.controller;

import com.uberall.demo.dto.LocationDTO;
import com.uberall.demo.service.LocationService;
import com.uberall.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Component
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    LocationService locationService;

    @PostMapping("/addLocationToH2")
    public Boolean addLocation(@RequestBody LocationDTO locationDto) {

        return locationService.addLocation(locationDto);
    }

    @PostMapping("/addLocationListToH2")
    public Boolean addLocationListToH2(@RequestBody List<LocationDTO> locationDtoList) {

        return locationService.addLocationList(locationDtoList);
    }

    @GetMapping("/getAllLocationFromH2Json")
    public List<LocationDTO> getLocationFromH2() {

        return locationService.getLocation();
    }

    @GetMapping("/getAllLocationFromH2CSV")
    public String getAllLocationFromH2CSV() {

        return Util.getCSVFromList(locationService.getLocation());
    }

}
