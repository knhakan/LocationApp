package com.uberall.demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uberall.demo.controller.ApiController;
import com.uberall.demo.dto.LocationDTO;
import com.uberall.demo.serviceimpl.LocationServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.junit.Assert;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    ApiController apiController;

    LocationServiceImpl locationService;
    // gets Json from resources and maps it to a single LocationDTO
    public LocationDTO getJson() {
        try {
            Gson gson = new Gson();
            File inRulesFile;

            inRulesFile = (new ClassPathResource("dataSingle.json")).getFile();
            byte[] encoded = Files.readAllBytes(Paths.get(String.valueOf(inRulesFile)));
            String contents = new String(encoded, StandardCharsets.US_ASCII);
            LocationDTO locationDTO = gson.fromJson(contents, LocationDTO.class);
            return locationDTO;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // gets Json as a list from resources and maps it to a LocationDTO list
    public List<LocationDTO> getJsonList() {

        try {
            Gson gson = new Gson();
            File inRulesFile;
            inRulesFile = (new ClassPathResource("dataList.json")).getFile();
            byte[] encoded = Files.readAllBytes(Paths.get(String.valueOf(inRulesFile)));
            String contents = new String(encoded, StandardCharsets.US_ASCII);

            List<LocationDTO> locationDTOList = gson.fromJson(contents, new TypeToken<List<LocationDTO>>() {
            }.getType());
            return locationDTOList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Test
    @DisplayName("Add location for a single component")
    public void T1_addLocation() {
        LocationDTO locationDTO = getJson();


        Assert.assertEquals(true,apiController.addLocation(locationDTO)) ;
    }


    @Test
    @DisplayName("Add location for a list")
    public void T2_addLocationList() {
        List<LocationDTO> locationDTOList = getJsonList();

        Assert.assertEquals(true,apiController.addLocationListToH2(locationDTOList)) ;

    }


    @Test
    @DisplayName("Get location from H2")
    public void T3_getLocationFromH2() {
        Assert.assertEquals(List.of(), apiController.getLocationFromH2());
    }


    @Test
    @DisplayName("Get locations from H2 to CSV")
    public void T4_getAllLocationFromH2CSV() {
        Assert.assertFalse(apiController.getAllLocationFromH2CSV().isEmpty());
    }
    
}
