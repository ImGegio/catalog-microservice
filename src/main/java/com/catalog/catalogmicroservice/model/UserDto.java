package com.catalog.catalogmicroservice.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class UserDto implements UserDetails {
    private Long userId;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String role;
    private String token;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return "{bcrypt}" + this.password;
    }
}
