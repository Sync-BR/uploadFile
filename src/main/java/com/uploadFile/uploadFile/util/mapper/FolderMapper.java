package com.uploadFile.uploadFile.util.mapper;

import com.uploadFile.uploadFile.model.dto.FolderDto;
import com.uploadFile.uploadFile.model.entity.FolderEntity;
import com.uploadFile.uploadFile.util.IdGeneratorService;
import org.springframework.stereotype.Component;

@Component
public class FolderMapper {
    private final ArchiveMapper archiveMapper;

    public FolderMapper(ArchiveMapper archiveMapper) {
        this.archiveMapper = archiveMapper;
    }

    public FolderEntity convertToEntity(FolderDto dto) {
        if (dto == null) {
            return new FolderEntity(IdGeneratorService.generateFolderIdentifier());
        }
        return new FolderEntity(dto.getFolderIdentifier());
    }

//    public FolderDto convertToDto(FolderEntity entity) {
//        return new FolderDto(
//                entity.getIdentifier(),
//                archiveMapper.convertListToDto(entity.getArchives())
//        );
//    }
public FolderDto convertToDto(FolderEntity entity) {
    return new FolderDto(
            entity.getIdentifier()
    );
}

}
