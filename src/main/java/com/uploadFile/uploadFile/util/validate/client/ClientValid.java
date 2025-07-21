package com.uploadFile.uploadFile.util.validate.client;

import com.uploadFile.uploadFile.handle.exception.ResourceAlreadyExistsException;
import com.uploadFile.uploadFile.model.dto.ClientDto;
import com.uploadFile.uploadFile.repository.ClientRepository;
import com.uploadFile.uploadFile.util.validate.Validator;
import org.springframework.stereotype.Component;

@Component
public class ClientValid implements Validator<ClientDto> {
    private final ClientRepository repository;

    public ClientValid(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(ClientDto object) {
        emailValidate(object.getClientEmail());
        phoneValidate(object.getClientPhone());
    }
    private void emailValidate(String email) {
        if(repository.findByEmail(email) != null){
            throw new ResourceAlreadyExistsException("Email already exists");
        }
    }
    private void phoneValidate(String phone) {
        if(repository.findByPhone(phone) != null){
            throw new ResourceAlreadyExistsException("Email already exists");
        }
    }
}
