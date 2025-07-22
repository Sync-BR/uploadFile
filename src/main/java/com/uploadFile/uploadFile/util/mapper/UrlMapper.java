package com.uploadFile.uploadFile.util.mapper;

import com.uploadFile.uploadFile.enums.FileVisibility;
import com.uploadFile.uploadFile.model.dto.UrlDto;
import com.uploadFile.uploadFile.model.entity.UrlEntity;
import org.springframework.stereotype.Component;

@Component
public class UrlMapper {

    public UrlEntity convertToEntity(UrlDto dto) {
        return new UrlEntity(
                dto.getUrlArchive(),
                FileVisibility.PUBLIC
        );

    }
    public UrlDto convertToDto(UrlEntity entity) {
        return new UrlDto(
                entity.getUrl(),
                FileVisibility.PUBLIC
        );

    }


}
