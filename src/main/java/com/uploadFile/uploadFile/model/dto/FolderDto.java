package com.uploadFile.uploadFile.model.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FolderDto {
    private String folderIdentifier;

    public FolderDto() {
    }

    public FolderDto(String folderIdentifier) {
        this.folderIdentifier = folderIdentifier;
    }

}
