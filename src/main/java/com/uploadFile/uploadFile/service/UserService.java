package com.uploadFile.uploadFile.service;

import com.uploadFile.uploadFile.model.dto.ClientDto;
import com.uploadFile.uploadFile.model.entity.ClientEntity;
import com.uploadFile.uploadFile.repository.ClientRepository;

import com.uploadFile.uploadFile.session.ClientSession;
import com.uploadFile.uploadFile.util.validate.user.LoginValid;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final LoginValid validator;
    private final ClientRepository repository;
    private final ClientSession session;

    public UserService(LoginValid validator, ClientRepository repository, ClientSession session) {
        this.validator = validator;
        this.repository = repository;
        this.session = session;
    }

    public void login(ClientDto dto) {
        ClientEntity searchClient = repository.findByEmailAndUser_Password(dto.getClientEmail(), dto.getClientUser().getPassword());
        validator.validate(searchClient);
        session.setSession(searchClient);
    }

}
