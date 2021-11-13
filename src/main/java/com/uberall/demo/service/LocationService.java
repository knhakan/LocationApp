package com.uberall.demo.service;

import com.uberall.demo.dto.LocationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    List<LocationDTO> getLocation();

    boolean addLocation(LocationDTO locationDTO);

    boolean addLocationList(List<LocationDTO> locationDTOList);
}
