package com.uploadFile.uploadFile.util.mapper;

import com.uploadFile.uploadFile.model.dto.ClientDto;
import com.uploadFile.uploadFile.model.entity.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    private final UserMapper userMapper;
    private final FolderMapper folderMapper;

    public ClientMapper(UserMapper userMapper, FolderMapper folderMapper) {
        this.userMapper = userMapper;
        this.folderMapper = folderMapper;
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

}
