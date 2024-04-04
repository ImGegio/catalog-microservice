package com.catalog.catalogmicroservice.model;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private String role;

    public LoginResponse(String accessToken, Long id, String username, String email, String role) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
