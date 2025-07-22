package com.uploadFile.uploadFile.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArchivesDto {
    private String name;
    private String path;
    private long size;
    private FolderDto folder;
    private UrlDto url;

    public ArchivesDto() {
    }

    public ArchivesDto(String name, String path, long size, FolderDto folder, UrlDto url) {
        this.name = name;
        this.path = path;
        this.size = size;
        this.folder = folder;
        this.url = url;
    }
}
