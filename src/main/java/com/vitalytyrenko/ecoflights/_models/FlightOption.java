package com.vitalytyrenko.ecoflights._models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightOption {
    private Airport fromAirport;
    private Airport toAirport;
    private double price;
    private int durationMinutes;
    private double carbonFootprintKg;
}
