package com.uploadFile.uploadFile.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String password;
    private String repeatPassword;

    public UserDto() {
    }

    public UserDto(String password, String repeatPassword) {
        this.password = password;
        this.repeatPassword = repeatPassword;
    }
}
