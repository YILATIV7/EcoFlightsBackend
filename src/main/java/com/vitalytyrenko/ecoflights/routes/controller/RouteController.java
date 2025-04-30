package com.vitalytyrenko.ecoflights.routes.controller;

import com.vitalytyrenko.ecoflights.routes.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @GetMapping("/search")
    public ResponseEntity<String> searchRoute(@RequestParam("from") String fromPlace,
                                      @RequestParam("to") String toPlace) {
        //return routeService.searchRoutes(fromPlace, toPlace);

        String json = "[\n" +
                "    {\n" +
                "        \"fromAirport\": {\n" +
                "            \"name\": \"Mărculeşti International Airport\",\n" +
                "            \"city\": \"Mărculeşti\",\n" +
                "            \"country\": \"Moldova\",\n" +
                "            \"iata_code\": \"\",\n" +
                "            \"icao_code\": \"LUBM\",\n" +
                "            \"latitude\": 47.862701416015625,\n" +
                "            \"longitude\": 28.212799072265625,\n" +
                "            \"altitude\": 312,\n" +
                "            \"timezone_offset\": 0.0,\n" +
                "            \"timezone\": \"\",\n" +
                "            \"type\": \"\",\n" +
                "            \"region\": \"airport\"\n" +
                "        },\n" +
                "        \"toAirport\": {\n" +
                "            \"name\": \"Paris-Orly Airport\",\n" +
                "            \"city\": \"Paris\",\n" +
                "            \"country\": \"France\",\n" +
                "            \"iata_code\": \"ORY\",\n" +
                "            \"icao_code\": \"LFPO\",\n" +
                "            \"latitude\": 48.7233333,\n" +
                "            \"longitude\": 2.3794444,\n" +
                "            \"altitude\": 291,\n" +
                "            \"timezone_offset\": 1.0,\n" +
                "            \"timezone\": \"E\",\n" +
                "            \"type\": \"Europe/Paris\",\n" +
                "            \"region\": \"airport\"\n" +
                "        },\n" +
                "        \"price\": 333.0,\n" +
                "        \"durationMinutes\": 227,\n" +
                "        \"carbonFootprintKg\": 123.0\n" +
                "    },\n" +
                "    {\n" +
                "        \"fromAirport\": {\n" +
                "            \"name\": \"Mărculeşti International Airport\",\n" +
                "            \"city\": \"Mărculeşti\",\n" +
                "            \"country\": \"Moldova\",\n" +
                "            \"iata_code\": \"\",\n" +
                "            \"icao_code\": \"LUBM\",\n" +
                "            \"latitude\": 47.862701416015625,\n" +
                "            \"longitude\": 28.212799072265625,\n" +
                "            \"altitude\": 312,\n" +
                "            \"timezone_offset\": 0.0,\n" +
                "            \"timezone\": \"\",\n" +
                "            \"type\": \"\",\n" +
                "            \"region\": \"airport\"\n" +
                "        },\n" +
                "        \"toAirport\": {\n" +
                "            \"name\": \"Paris-Orly Airport\",\n" +
                "            \"city\": \"Paris\",\n" +
                "            \"country\": \"France\",\n" +
                "            \"iata_code\": \"ORY\",\n" +
                "            \"icao_code\": \"LFPO\",\n" +
                "            \"latitude\": 48.7233333,\n" +
                "            \"longitude\": 2.3794444,\n" +
                "            \"altitude\": 291,\n" +
                "            \"timezone_offset\": 1.0,\n" +
                "            \"timezone\": \"E\",\n" +
                "            \"type\": \"Europe/Paris\",\n" +
                "            \"region\": \"airport\"\n" +
                "        },\n" +
                "        \"price\": 178.0,\n" +
                "        \"durationMinutes\": 230,\n" +
                "        \"carbonFootprintKg\": 104.0\n" +
                "    },\n" +
                "    {\n" +
                "        \"fromAirport\": {\n" +
                "            \"name\": \"Mărculeşti International Airport\",\n" +
                "            \"city\": \"Mărculeşti\",\n" +
                "            \"country\": \"Moldova\",\n" +
                "            \"iata_code\": \"\",\n" +
                "            \"icao_code\": \"LUBM\",\n" +
                "            \"latitude\": 47.862701416015625,\n" +
                "            \"longitude\": 28.212799072265625,\n" +
                "            \"altitude\": 312,\n" +
                "            \"timezone_offset\": 0.0,\n" +
                "            \"timezone\": \"\",\n" +
                "            \"type\": \"\",\n" +
                "            \"region\": \"airport\"\n" +
                "        },\n" +
                "        \"toAirport\": {\n" +
                "            \"name\": \"Paris-Orly Airport\",\n" +
                "            \"city\": \"Paris\",\n" +
                "            \"country\": \"France\",\n" +
                "            \"iata_code\": \"ORY\",\n" +
                "            \"icao_code\": \"LFPO\",\n" +
                "            \"latitude\": 48.7233333,\n" +
                "            \"longitude\": 2.3794444,\n" +
                "            \"altitude\": 291,\n" +
                "            \"timezone_offset\": 1.0,\n" +
                "            \"timezone\": \"E\",\n" +
                "            \"type\": \"Europe/Paris\",\n" +
                "            \"region\": \"airport\"\n" +
                "        },\n" +
                "        \"price\": 104.0,\n" +
                "        \"durationMinutes\": 263,\n" +
                "        \"carbonFootprintKg\": 220.0\n" +
                "    }\n" +
                "]";

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);
    }
}
