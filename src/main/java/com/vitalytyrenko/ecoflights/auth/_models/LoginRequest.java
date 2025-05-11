package com.vitalytyrenko.ecoflights.auth._models;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}

