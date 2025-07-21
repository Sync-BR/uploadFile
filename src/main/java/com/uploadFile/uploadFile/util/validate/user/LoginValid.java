package com.uploadFile.uploadFile.util.validate.user;

import com.uploadFile.uploadFile.handle.exception.LoginException;
import com.uploadFile.uploadFile.model.dto.ClientDto;
import com.uploadFile.uploadFile.model.entity.ClientEntity;
import com.uploadFile.uploadFile.util.validate.Validator;
import org.springframework.stereotype.Component;

@Component
public class LoginValid implements Validator<ClientEntity> {


    @Override
    public void validate(ClientEntity object) {
        if(object == null){
            throw new LoginException("Login ou senha incorreto");
        }
    }
}
