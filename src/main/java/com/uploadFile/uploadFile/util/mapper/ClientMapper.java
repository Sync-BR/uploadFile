package com.uploadFile.uploadFile.util.mapper;

import com.uploadFile.uploadFile.model.dto.ClientDto;
import com.uploadFile.uploadFile.model.entity.ClientEntity;
import com.uploadFile.uploadFile.model.entity.UserEntity;
import com.uploadFile.uploadFile.util.PasswordGenerate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ClientMapper {
    private final UserMapper userMapper;
    private final FolderMapper folderMapper;
    private final PasswordGenerate  passwordGenerate;

    public ClientMapper(UserMapper userMapper, FolderMapper folderMapper, PasswordGenerate passwordGenerate) {
        this.userMapper = userMapper;
        this.folderMapper = folderMapper;
        this.passwordGenerate = passwordGenerate;
    }

    public ClientEntity convertToEntity(ClientDto dto) {
        return new ClientEntity(
                dto.getClientName(),
                dto.getClientEmail(),
                dto.getClientPhone(),
                userMapper.convertToEntity(dto.getClientUser()),
                folderMapper.convertToEntity(dto.getClientFolder())
        );
    }


    public ClientEntity createOAuth2ToEntity(ClientDto dto) {
        return new ClientEntity(
                dto.getClientName(),
                dto.getClientEmail(),
                dto.getClientPhone(),
                new UserEntity(passwordGenerate.generate()),
                folderMapper.convertToEntity(dto.getClientFolder())
        );
    }





}
