package com.vitalytyrenko.ecoflights.routes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteRequest {
    private String fromLocation;
    private String toLocation;
}
