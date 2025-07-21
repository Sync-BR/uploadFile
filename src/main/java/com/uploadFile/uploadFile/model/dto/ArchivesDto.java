package com.uploadFile.uploadFile.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ArchivesDto {
    private String name;
    private String path;
    private long size;
    @ToString.Exclude
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
