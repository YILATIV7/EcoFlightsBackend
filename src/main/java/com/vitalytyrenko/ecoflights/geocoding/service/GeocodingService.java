package com.vitalytyrenko.ecoflights.geocoding.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitalytyrenko.ecoflights._models.Coordinates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class GeocodingService {

    @Value("${google.api.key}")
    private String apiKey;

    private static final String GEOCODING_API_URL = "https://maps.googleapis.com/maps/api/geocode/json";

    public Coordinates getCoordinates(String place) {
        try {
            String encodedPlace = URLEncoder.encode(place, StandardCharsets.UTF_8);
            String url = GEOCODING_API_URL + "?address=" + encodedPlace + "&key=" + apiKey;

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            StringBuilder response;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response.toString());

            JsonNode location = root.path("results").get(0).path("geometry").path("location");
            double lat = location.path("lat").asDouble();
            double lng = location.path("lng").asDouble();

            return new Coordinates(lat, lng);

        } catch (Exception e) {
            throw new RuntimeException("Failed to get coordinates for: " + place, e);
        }
    }
}
