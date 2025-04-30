package com.vitalytyrenko.ecoflights.routes.service;

import com.vitalytyrenko.ecoflights._models.Airport;
import com.vitalytyrenko.ecoflights._models.Coordinates;
import com.vitalytyrenko.ecoflights._models.FlightOption;
import com.vitalytyrenko.ecoflights.airportnearest.service.AirportNearestService;
import com.vitalytyrenko.ecoflights.flightsearch.service.FlightSearchService;
import com.vitalytyrenko.ecoflights.geocoding.service.GeocodingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final GeocodingService geocodingService;
    private final AirportNearestService airportNearestService;
    private final FlightSearchService flightSearchService;

    public List<FlightOption> searchRoutes(String fromPlace, String toPlace) {

        // Геокодування
        Coordinates fromCoords = geocodingService.getCoordinates(fromPlace);
        Coordinates toCoords = geocodingService.getCoordinates(toPlace);

        System.out.println("From: " + fromCoords + " To: " + toCoords);

        // Пошук найближчих аеропортів
        Airport nearestFromAirport = airportNearestService.findNearestAirport(fromCoords);
        Airport nearestToAirport = airportNearestService.findNearestAirport(toCoords);

        System.out.println("nearestFromAirport: " + nearestFromAirport);
        System.out.println("nearestToAirport" + nearestToAirport);

        // Пошук доступних авіарейсів між аеропортами
        List<FlightOption> flightOptions = flightSearchService.findFlights(nearestFromAirport, nearestToAirport);

        return flightOptions;
//
//        // 4. Побудова мультимодальних маршрутів
//        List<RouteOption> multimodalRoutes = multimodalBuilder.buildRoutes(
//                flightOptions, fromCoords, toCoords
//        );
//
//        // 5. Оцінка та сортування маршрутів за критеріями: вартість, час, екологічність
//        List<RouteOption> rankedRoutes = routeEvaluator.rankRoutes(multimodalRoutes);
//
//        // 6. Повертаємо відсортований список найкращих маршрутів
//        return rankedRoutes;
    }
}
