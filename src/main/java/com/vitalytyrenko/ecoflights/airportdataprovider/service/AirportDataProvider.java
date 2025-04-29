package com.vitalytyrenko.ecoflights.airportdataprovider.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitalytyrenko.ecoflights._models.Airport;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AirportDataProvider {

    private final ObjectMapper objectMapper;

    @Getter
    private List<Airport> allAirports;

    @Getter
    private List<Airport> bigAirports;

    @PostConstruct
    public void loadAirports() {
        try {
            InputStream allInputStream = new ClassPathResource("static/airports.json").getInputStream();
            allAirports = objectMapper.readValue(allInputStream, new TypeReference<>() {});

            InputStream bigInputStream = new ClassPathResource("static/big-airports.json").getInputStream();
            bigAirports = objectMapper.readValue(bigInputStream, new TypeReference<>() {});

            log.info("Loaded {} airports and {} big airports", allAirports.size(), bigAirports.size());

        } catch (IOException e) {
            log.error("Failed to load airport data", e);
            throw new RuntimeException("Failed to load airport data", e);
        }
    }
}

