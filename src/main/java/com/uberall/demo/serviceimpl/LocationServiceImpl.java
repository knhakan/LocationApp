package com.uberall.demo.serviceimpl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uberall.demo.dto.LocationDTO;
import com.uberall.demo.dto.OpeningHoursDTO;
import com.uberall.demo.model.Location;
import com.uberall.demo.repository.LocationRepository;
import com.uberall.demo.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<LocationDTO> getLocation() {

        List<Location> locations = new ArrayList<Location>();
        locationRepository.findAll().forEach(location -> locations.add(location));
        List<LocationDTO> locationsDto = new ArrayList<LocationDTO>();
        locations.forEach(location -> locationsDto.add(modelToDTO(location)));
        return locationsDto;

    }

    @Override
    public boolean addLocation(LocationDTO locationDTO) {

        Location location = dtoToModel(locationDTO);
        locationRepository.save(location);
        return true;

    }

    @Override
    public boolean addLocationList(List<LocationDTO> locationDTOList) {

        List<Location> locationList = new ArrayList<Location>();
        locationDTOList.forEach(locationDto -> locationList.add(dtoToModel(locationDto)));
        locationRepository.saveAll(locationList);
        return true;
    }


    private LocationDTO modelToDTO(Location location) {
        Gson gson = new Gson();
        LocationDTO locationDTO = modelMapper.map(location, LocationDTO.class);


        // convert json string to openingHoursDTO Class
        Type listType = new TypeToken<ArrayList<OpeningHoursDTO>>() {}.getType();
        List<OpeningHoursDTO> openingHoursDTOList = new Gson().fromJson(location.getOpeningHours(), listType);

        locationDTO.setOpeningHours(openingHoursDTOList);

        // convert comma separated string to list of string
        List<String> keywords = Arrays.asList(location.getLocationKeywords().split("\\s*,\\s*"));
        locationDTO.setKeywords(keywords);

        return locationDTO;
    }


    private Location dtoToModel(LocationDTO locationDTO) {
        Gson gson = new Gson();
        Location location = modelMapper.map(locationDTO, Location.class);

        // convert OpeningHoursClass to jsonString
        location.setOpeningHours(gson.toJson(locationDTO.getOpeningHours()));

        // convert list of string to comma separated string
        String keywordsCommaSeparated = String.join(",", locationDTO.getKeywords());

        location.setLocationKeywords(keywordsCommaSeparated);

        return location;
    }


}
