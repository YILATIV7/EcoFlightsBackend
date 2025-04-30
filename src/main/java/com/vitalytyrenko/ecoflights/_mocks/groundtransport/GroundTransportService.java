package com.vitalytyrenko.ecoflights._mocks.groundtransport;

import com.vitalytyrenko.ecoflights._mocks._models.GroundSegment;
import com.vitalytyrenko.ecoflights._mocks._models.TransportType;
import com.vitalytyrenko.ecoflights._models.Coordinates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class GroundTransportService {

    private final Random random = new Random();

    /**
     * Створює наземний сегмент між двома координатами.
     * Поки що дані мокаються, але структура готова для підключення до Google Directions API або іншого сервісу.
     */
    public GroundSegment buildGroundSegment(Coordinates from, Coordinates to) {
        // Поки що імітація на основі відстані
        double distanceKm = haversine(from.getLatitude(), from.getLongitude(), to.getLatitude(), to.getLongitude());

        // Визначення транспортного засобу (спрощено)
        TransportType type = (distanceKm > 50) ? TransportType.TRAIN : TransportType.CAR;

        // Розрахунок параметрів (наближено)
        int durationMinutes = (int) (distanceKm / (type == TransportType.CAR ? 50 : 80) * 60); // середня швидкість
        double price = distanceKm * (type == TransportType.CAR ? 0.2 : 0.1);
        double co2 = distanceKm * (type == TransportType.CAR ? 0.12 : 0.04);

        return GroundSegment.builder()
                .from(from)
                .to(to)
                .transportType(type)
                .durationMinutes(durationMinutes)
                .price(price)
                .carbonFootprintKg(co2)
                .build();
    }

    /**
     * Формула Гаверсина для обчислення відстані між двома координатами.
     */
    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Радіус Землі в км
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.pow(Math.sin(dLat / 2), 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
