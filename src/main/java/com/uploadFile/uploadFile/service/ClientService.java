package com.uploadFile.uploadFile.service;

import com.uploadFile.uploadFile.model.dto.ClientDto;
import com.uploadFile.uploadFile.repository.ClientRepository;
import com.uploadFile.uploadFile.service.interfaces.ServiceInterface;
import com.uploadFile.uploadFile.util.mapper.ClientMapper;
import com.uploadFile.uploadFile.util.validate.client.ClientValid;
import com.uploadFile.uploadFile.util.validate.user.UserValid;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements ServiceInterface<ClientDto> {
    private final ClientMapper mapper;

    private final ClientValid validClient;
    private final UserValid validUser;

    private final ClientRepository repository;


    public ClientService(ClientMapper mapper, ClientValid validClient, UserValid validUser, ClientRepository repository) {
        this.mapper = mapper;
        this.validClient = validClient;
        this.validUser = validUser;
        this.repository = repository;
    }

    @Override
    public void save(ClientDto dto) {
        validClient.validate(dto);
        validUser.validate(dto.getClientUser());
        System.out.println(mapper.convertToEntity(dto));
        repository.save(mapper.convertToEntity(dto));
    }

    @Override
    public void delete(ClientDto dto) {

    }

    @Override
    public ClientDto update(ClientDto dto) {
        return null;
    }
}
