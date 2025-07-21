package com.uploadFile.uploadFile.util.mapper;

import com.uploadFile.uploadFile.model.dto.UserDto;
import com.uploadFile.uploadFile.model.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity convertToEntity(UserDto dto) {
        return new UserEntity(
                dto.getPassword()
        );
    }
}
