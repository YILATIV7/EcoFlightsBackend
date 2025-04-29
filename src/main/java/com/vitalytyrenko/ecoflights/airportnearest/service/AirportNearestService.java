package com.vitalytyrenko.ecoflights.airportnearest.service;

import com.vitalytyrenko.ecoflights._models.Coordinates;
import com.vitalytyrenko.ecoflights._models.Airport;
import com.vitalytyrenko.ecoflights.airportdataprovider.service.AirportDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportNearestService {

    private final AirportDataProvider airportDataProvider; // Клас для завантаження аеропортів

    private static final double EARTH_RADIUS_KM = 6371.0;

    public Airport findNearestAirport(Coordinates userCoords) {
        List<Airport> bigAirports = airportDataProvider.getBigAirports();
        List<Airport> allAirports = airportDataProvider.getAllAirports();

        Airport nearest = findNearestWithinRadius(bigAirports, userCoords);

        if (nearest == null) {
            nearest = findNearest(allAirports, userCoords);
        }

        return nearest;
    }

    private Airport findNearestWithinRadius(List<Airport> airports, Coordinates coords) {
        final double radiusKm = 200.0;

        Airport nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (Airport airport : airports) {
            double distance = calculateHaversineDistance(
                    coords.getLatitude(), coords.getLongitude(),
                    airport.getLatitude(), airport.getLongitude()
            );
            if (distance <= radiusKm && distance < minDistance) {
                minDistance = distance;
                nearest = airport;
            }
        }
        return nearest;
    }

    private Airport findNearest(List<Airport> airports, Coordinates coords) {
        Airport nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (Airport airport : airports) {
            double distance = calculateHaversineDistance(
                    coords.getLatitude(), coords.getLongitude(),
                    airport.getLatitude(), airport.getLongitude()
            );
            if (distance < minDistance) {
                minDistance = distance;
                nearest = airport;
            }
        }
        return nearest;
    }

    private double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return EARTH_RADIUS_KM * c;
    }
}

