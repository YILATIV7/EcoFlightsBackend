package com.vitalytyrenko.ecoflights.routes.controller;

import com.vitalytyrenko.ecoflights.routes.dto.RouteRequest;
import com.vitalytyrenko.ecoflights.routes.dto.RouteResponse;
import com.vitalytyrenko.ecoflights.routes.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @PostMapping("/search")
    public ResponseEntity<RouteResponse> searchRoute(@RequestBody RouteRequest request) {
        RouteResponse response = routeService.processRouteRequest(request);
        return ResponseEntity.ok(response);
    }
}
