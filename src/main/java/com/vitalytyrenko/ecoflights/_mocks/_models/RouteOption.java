package com.vitalytyrenko.ecoflights._mocks._models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteOption {

    private List<RouteSegment> segments;

    private double totalPrice;
    private int totalDurationMinutes;
    private double totalCarbonFootprintKg;

    public static RouteOption of(List<RouteSegment> segments) {
        double totalPrice = segments.stream()
                .mapToDouble(RouteSegment::getPrice)
                .sum();

        int totalDuration = segments.stream()
                .mapToInt(RouteSegment::getDurationMinutes)
                .sum();

        double totalCO2 = segments.stream()
                .mapToDouble(RouteSegment::getCarbonFootprintKg)
                .sum();

        return RouteOption.builder()
                .segments(segments)
                .totalPrice(totalPrice)
                .totalDurationMinutes(totalDuration)
                .totalCarbonFootprintKg(totalCO2)
                .build();
    }
}

