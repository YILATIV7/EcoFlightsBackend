package com.vitalytyrenko.ecoflights.airport.controller;

import com.vitalytyrenko.ecoflights.airport.dto.Airport;
import com.vitalytyrenko.ecoflights.airport.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Airport> getAllAirports() {
        return service.getAllAirports();
    }

    @GetMapping("/big")
    public List<Airport> getBigAirports() {
        return service.getBigAirports();
    }
}

