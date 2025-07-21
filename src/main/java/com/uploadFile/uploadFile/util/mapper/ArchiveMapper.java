package com.uploadFile.uploadFile.util.mapper;

import com.uploadFile.uploadFile.model.dto.ArchivesDto;
import com.uploadFile.uploadFile.model.entity.ArchiveEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArchiveMapper {
    private final FolderMapper folderMapper;
    private final UrlMapper urlMapper;



    public ArchiveMapper(@Lazy FolderMapper folderMapper, UrlMapper urlMapper) {
        this.folderMapper = folderMapper;
        this.urlMapper = urlMapper;
    }

    public List<ArchivesDto> convertListToDto(List<ArchiveEntity> archiveEntities) {
        List<ArchivesDto> archivesDtos = new ArrayList<>();
        for (ArchiveEntity entity : archiveEntities) {
            ArchivesDto dt = new ArchivesDto(
                    entity.getArchiveName(),
                    entity.getArchivePath(),
                    entity.getSize(),
                    folderMapper.convertToDto(entity.getFolder()),
                    urlMapper.convertToDto(entity.getUrl())
            );
            archivesDtos.add(dt);
        }
        return archivesDtos;
    }

    public List<ArchiveEntity> convertListToEntity(List<ArchivesDto> clientArchives) {
        ArrayList<ArchiveEntity> archiveEntities = new ArrayList<>();
        for(ArchivesDto archivesDto : clientArchives){
            ArchiveEntity archiveEntity = new ArchiveEntity(
                    archivesDto.getName(),
                    archivesDto.getPath(),
                    archivesDto.getSize(),
                    folderMapper.convertToEntity(archivesDto.getFolder()),
                    urlMapper.convertToEntity(archivesDto.getUrl())
            );
            archiveEntities.add(archiveEntity);
        }
        return archiveEntities;
    }
    public ArchiveEntity convertToEntity(ArchivesDto dto) {
        return new ArchiveEntity(
                dto.getName(),
                dto.getPath(),
                dto.getSize(),
                folderMapper.convertToEntity(dto.getFolder()),
                urlMapper.convertToEntity(dto.getUrl())
        );
    }

}
