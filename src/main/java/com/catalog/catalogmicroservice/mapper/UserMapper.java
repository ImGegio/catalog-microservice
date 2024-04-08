package com.catalog.catalogmicroservice.mapper;

import com.catalog.catalogmicroservice.entity.User;
import com.catalog.catalogmicroservice.model.UserDto;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user){
        UserDto dto = new UserDto();

        BeanUtils.copyProperties(user, dto);
        return dto;
    }
}
