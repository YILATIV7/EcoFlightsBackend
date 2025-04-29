package com.vitalytyrenko.ecoflights.routes.controller;

import com.vitalytyrenko.ecoflights.routes.service.RouteService;
import lombok.RequiredArgsConstructor;
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
    public void searchRoute(@RequestParam("from") String fromPlace,
                            @RequestParam("to") String toPlace) {
        routeService.searchRoutes(fromPlace, toPlace);
    }
}
