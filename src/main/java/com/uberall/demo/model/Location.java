package com.uberall.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @Column
    private String name;

    @Column
    private String city;

    @Column
    private String zip;

    @Column
    private String streetAndNumber;

    @Column
    private double lat;

    @Column
    private double lng;


    @Column(name = "locationKeywords", nullable = false, length = 2000)
    private String locationKeywords;


    @Column(name = "openingHours", nullable = false, length = 2000)
    private String openingHours;


    ////GETTER AND SETTER


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getLocationKeywords() {
        return locationKeywords;
    }

    public void setLocationKeywords(String locationKeywords) {
        this.locationKeywords = locationKeywords;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

}
