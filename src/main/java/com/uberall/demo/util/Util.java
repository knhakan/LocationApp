package com.uberall.demo.util;

import com.uberall.demo.dto.LocationDTO;

import java.util.List;

public class Util {
    public static final String CSV_SEPARATOR = ",";

    public static String getCSVFromList(List<LocationDTO> locationList) {
        String csvStringList = "";

        for (LocationDTO locationDto : locationList) {

            StringBuffer oneLine = new StringBuffer();
            // name
            oneLine.append(locationDto.getName() == null ? "" : locationDto.getName());
            oneLine.append(CSV_SEPARATOR);

            // city
            oneLine.append(locationDto.getCity() == null ? "" : locationDto.getCity());
            oneLine.append(CSV_SEPARATOR);

            // zip
            oneLine.append(locationDto.getZip() == null ? "" : locationDto.getZip());
            oneLine.append(CSV_SEPARATOR);

            // streetAndNumber
            oneLine.append(locationDto.getStreetAndNumber() == null ? "" : locationDto.getStreetAndNumber());
            oneLine.append(CSV_SEPARATOR);

            // lat
            oneLine.append(locationDto.getLat() == 0 ? "" : locationDto.getLat());
            oneLine.append(CSV_SEPARATOR);

            // lng
            oneLine.append(locationDto.getLng() == 0 ? "" : locationDto.getLng());
            oneLine.append(CSV_SEPARATOR);

            // keywords
            oneLine.append(locationDto.getKeywords().isEmpty() ? "" : String.join(",", locationDto.getKeywords()));

            csvStringList += oneLine + System.lineSeparator();
        }
        return csvStringList;
    }

}
