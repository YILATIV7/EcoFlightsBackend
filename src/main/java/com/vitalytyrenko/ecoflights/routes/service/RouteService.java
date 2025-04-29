package com.vitalytyrenko.ecoflights.routes.service;

import com.vitalytyrenko.ecoflights.routes.dto.RouteRequest;
import com.vitalytyrenko.ecoflights.routes.dto.RouteResponse;
import com.vitalytyrenko.ecoflights._models.Coordinates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    public RouteResponse processRouteRequest(RouteRequest request) {
        // 1. Геокодування
        Coordinates from = geocode(request.getFromLocation());
        Coordinates to = geocode(request.getToLocation());

        // 2. Найближчі аеропорти (умовно)
        String nearestFrom = findNearestAirport(from);
        String nearestTo = findNearestAirport(to);

        // 3. Побудова списку маршрутів (максимально спрощено)
        List<String> routes = List.of(
                nearestFrom + " -> " + nearestTo + " (direct flight)"
        );

        return new RouteResponse(nearestFrom, nearestTo, routes);
    }

    private Coordinates geocode(String location) {
        // Псевдо-геокодування, заглушка
        return new Coordinates(50.45, 30.52); // Київ
    }

    private String findNearestAirport(Coordinates coords) {
        // Псевдологіка пошуку найближчого аеропорту
        return "KBP"; // Бориспіль
    }
}
