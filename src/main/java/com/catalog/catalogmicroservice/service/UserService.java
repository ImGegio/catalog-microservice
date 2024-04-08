package com.catalog.catalogmicroservice.service;

import com.catalog.catalogmicroservice.entity.User;
import com.catalog.catalogmicroservice.mapper.UserMapper;
import com.catalog.catalogmicroservice.model.UserDto;
import com.catalog.catalogmicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

        return userMapper.toDto(user);
    }
}
