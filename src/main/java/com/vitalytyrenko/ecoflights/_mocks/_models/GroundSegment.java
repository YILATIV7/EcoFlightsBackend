package com.vitalytyrenko.ecoflights._mocks._models;

import com.vitalytyrenko.ecoflights._models.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// GroundSegment.java
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GroundSegment implements RouteSegment {
    private Coordinates from;
    private Coordinates to;
    private TransportType transportType;
    private int durationMinutes;
    private double price;
    private double carbonFootprintKg;
}
