package com.uploadFile.uploadFile.util.validate.user;

import com.uploadFile.uploadFile.handle.exception.ResourceAlreadyExistsException;
import com.uploadFile.uploadFile.model.dto.UserDto;
import com.uploadFile.uploadFile.util.validate.Validator;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class UserValid implements Validator<UserDto> {
    @Override
    public void validate(UserDto object) {
        if(!Objects.equals(object.getPassword(), object.getRepeatPassword())){
            throw new ResourceAlreadyExistsException("Senha precisar ser igual");
        }
    }


}
