package com.vitalytyrenko.ecoflights.flightsearch.service;

import com.vitalytyrenko.ecoflights._models.Airport;
import com.vitalytyrenko.ecoflights._models.FlightOption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class FlightSearchService {

    private final Random random = new Random();

    /**
     * Пошук можливих рейсів між двома аеропортами.
     */
    public List<FlightOption> findFlights(Airport from, Airport to) {
        List<FlightOption> flights = new ArrayList<>();

        // Поки що імітуємо результати пошуку
        if (from != null && to != null) {
            for (int i = 0; i < random.nextInt(3) + 1; i++) { // 1–3 варіанти
                flights.add(generateMockFlight(from, to));
            }
        }

        return flights;
    }

    private FlightOption generateMockFlight(Airport from, Airport to) {
        return FlightOption.builder()
                .fromAirport(from)
                .toAirport(to)
                .price(100 + random.nextInt(500)) // випадкова ціна від 100 до 600
                .durationMinutes(60 + random.nextInt(600)) // тривалість від 1 до 10 годин
                .carbonFootprintKg(50 + random.nextInt(300)) // викиди CO2
                .build();
    }
}

