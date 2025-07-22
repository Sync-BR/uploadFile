package com.uploadFile.uploadFile.model.dto;

import com.uploadFile.uploadFile.enums.FileVisibility;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlDto {
    private String urlArchive;
    @Enumerated(EnumType.STRING)
    private FileVisibility visibility;

    public UrlDto(String urlArchive, FileVisibility visibility) {
        this.urlArchive = urlArchive;
        this.visibility = visibility;
    }
}
