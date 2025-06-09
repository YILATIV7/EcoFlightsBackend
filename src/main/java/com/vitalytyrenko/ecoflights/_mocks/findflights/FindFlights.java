package com.vitalytyrenko.ecoflights._mocks.findflights;

import com.vitalytyrenko.ecoflights._models.Airport;
import com.vitalytyrenko.ecoflights._models.FlightOption;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindFlights {

    private final RestTemplate restTemplate;

    @Value("${api.serp.base-url}")
    private String serpApiBaseUrl;

    @Value("${api.serp.key}")
    private String serpApiKey;

    public List<FlightOption> findFlights(Airport from, Airport to) {
        String url = UriComponentsBuilder.fromHttpUrl(serpApiBaseUrl)
                .queryParam("engine", "google_flights")
                .queryParam("departure_id", from.getIata_code())
                .queryParam("arrival_id", to.getIata_code())
                .queryParam("hl", "en")
                .queryParam("api_key", serpApiKey)
                .toUriString();

        FlightOption[] response = restTemplate.getForObject(url, FlightOption[].class);
        return response != null ? Arrays.asList(response) : List.of();
    }
}

