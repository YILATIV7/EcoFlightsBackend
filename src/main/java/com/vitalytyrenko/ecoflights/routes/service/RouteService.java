package com.vitalytyrenko.ecoflights.routes.service;

import com.vitalytyrenko.ecoflights.geocoding.service.GeocodingService;
import com.vitalytyrenko.ecoflights.routes.dto.RouteRequest;
import com.vitalytyrenko.ecoflights.routes.dto.RouteResponse;
import com.vitalytyrenko.ecoflights._models.Coordinates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final GeocodingService geocodingService;

    public void searchRoutes(String fromPlace, String toPlace) {
        // 1. Геокодування початкової та кінцевої точки
        Coordinates fromCoords = geocodingService.getCoordinates(fromPlace);
        Coordinates toCoords = geocodingService.getCoordinates(toPlace);

        System.out.println("From: " + fromCoords + " To: " + toCoords);

//        // 2. Пошук найближчих великих аеропортів
//        Airport nearestFromAirport = airportSearchService.findNearestAirport(fromCoords);
//        Airport nearestToAirport = airportSearchService.findNearestAirport(toCoords);
//
//        // 3. Пошук доступних авіарейсів між аеропортами
//        List<FlightOption> flightOptions = flightSearchService.findFlights(nearestFromAirport, nearestToAirport);
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
