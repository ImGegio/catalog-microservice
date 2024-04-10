package com.catalog.catalogmicroservice.service;

import com.catalog.catalogmicroservice.entity.User;
import com.catalog.catalogmicroservice.mapper.UserMapper;
import com.catalog.catalogmicroservice.model.UserDto;
import com.catalog.catalogmicroservice.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) throw new UsernameNotFoundException("Utente non trovato");

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Scadenza in 1 giorno
                .signWith(HS256, Keys.secretKeyFor(HS256))
                .compact();

        UserDto userDto = userMapper.toDto(user);
        userDto.setToken(token);

        return userDto;
    }
}
