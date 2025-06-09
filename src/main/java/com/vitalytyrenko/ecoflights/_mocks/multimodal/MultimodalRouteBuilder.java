package com.vitalytyrenko.ecoflights._mocks.multimodal;

import com.vitalytyrenko.ecoflights._mocks._models.GroundSegment;
import com.vitalytyrenko.ecoflights._mocks._models.RouteOption;
import com.vitalytyrenko.ecoflights._mocks.groundtransport.GroundTransportService;
import com.vitalytyrenko.ecoflights._models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MultimodalRouteBuilder {

    private final GroundTransportService groundTransportService;

    public List<RouteOption> buildRoutes(List<FlightOption> flights, Coordinates userStart, Coordinates userEnd) {
        List<RouteOption> routeOptions = new ArrayList<>();

        for (FlightOption flight : flights) {
            // Побудова наземної ділянки до аеропорту відправлення
            GroundSegment toAirport = groundTransportService.buildGroundSegment(
                    userStart, flight.getFromAirport().getCoordinates());

            // Побудова наземної ділянки від аеропорту прибуття
            GroundSegment fromAirport = groundTransportService.buildGroundSegment(
                    flight.getToAirport().getCoordinates(), userEnd);

            // Підрахунок загального часу, вартості та викидів
            int totalDuration = toAirport.getDurationMinutes()
                    + flight.getDurationMinutes()
                    + fromAirport.getDurationMinutes();

            double totalPrice = toAirport.getPrice()
                    + flight.getPrice()
                    + fromAirport.getPrice();

            double totalCarbon = toAirport.getCarbonFootprintKg()
                    + flight.getCarbonFootprintKg()
                    + fromAirport.getCarbonFootprintKg();

            RouteOption route = RouteOption.builder()
                    .segments(List.of())
                    .totalDurationMinutes(totalDuration)
                    .totalPrice(totalPrice)
                    .totalCarbonFootprintKg(totalCarbon)
                    .build();

            routeOptions.add(route);
        }

        return routeOptions;
    }
}

