package com.vitalytyrenko.ecoflights._mocks._models;

import com.vitalytyrenko.ecoflights._models.Coordinates;

public interface RouteSegment {
    Coordinates getFrom();
    Coordinates getTo();
    int getDurationMinutes();
    double getPrice();
    double getCarbonFootprintKg();
}
