package com.vitalytyrenko.ecoflights.auth._models;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
    private String fullName;
}

