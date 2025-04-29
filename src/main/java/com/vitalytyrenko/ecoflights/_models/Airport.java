package com.vitalytyrenko.ecoflights._models;

import lombok.Data;

@Data
public class Airport {
    private String name;
    private String city;
    private String country;
    private String iata_code;
    private String icao_code;
    private double latitude;
    private double longitude;
    private int altitude;
    private double timezone_offset;
    private String timezone;
    private String type;
    private String region;
}
