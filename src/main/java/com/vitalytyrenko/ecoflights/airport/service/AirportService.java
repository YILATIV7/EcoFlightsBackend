package com.vitalytyrenko.ecoflights.airport.service;

import com.vitalytyrenko.ecoflights.airport.dto.Airport;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;

@Service
public class AirportService {

    private final List<Airport> allAirports = new ArrayList<>();
    private final List<Airport> bigAirports = new ArrayList<>();

    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream allInput = getClass().getResourceAsStream("/static/airports.json");
            InputStream bigInput = getClass().getResourceAsStream("/static/big-airports.json");

            if (allInput != null) {
                allAirports.addAll(mapper.readValue(allInput, new TypeReference<List<Airport>>() {}));
            }

            if (bigInput != null) {
                bigAirports.addAll(mapper.readValue(bigInput, new TypeReference<List<Airport>>() {}));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Airport> getAllAirports() {
        return allAirports;
    }

    public List<Airport> getBigAirports() {
        return bigAirports;
    }
}
