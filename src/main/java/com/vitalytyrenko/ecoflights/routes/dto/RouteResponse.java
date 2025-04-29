package com.vitalytyrenko.ecoflights.routes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteResponse {
    private String nearestDepartureAirport;
    private String nearestArrivalAirport;
    private List<String> suggestedRoutes;
}
