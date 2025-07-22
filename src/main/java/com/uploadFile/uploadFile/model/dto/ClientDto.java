package com.uploadFile.uploadFile.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto {
    private String clientName;
    private String clientEmail;
    private String clientPhone;

    private UserDto clientUser;
    private FolderDto clientFolder;

    public ClientDto() {
    }

    public ClientDto(String clientName, String clientEmail, String clientPhone, UserDto clientUser, FolderDto clientFolder) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
        this.clientUser = clientUser;
        this.clientFolder = clientFolder;
    }
}
