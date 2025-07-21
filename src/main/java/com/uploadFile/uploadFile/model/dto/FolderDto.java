package com.uploadFile.uploadFile.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FolderDto {
    private String folderIdentifier;

//    private List<ArchivesDto> clientArchives;

    public FolderDto() {
    }

    public FolderDto(String folderIdentifier) {
        this.folderIdentifier = folderIdentifier;
    }
//
//    public FolderDto(String folderIdentifier, List<ArchivesDto> clientArchives) {
//        this.folderIdentifier = folderIdentifier;
//        this.clientArchives = clientArchives;
//    }
}
