package com.uploadFile.uploadFile.service;

import com.uploadFile.uploadFile.enums.FileVisibility;
import com.uploadFile.uploadFile.model.dto.ArchivesDto;
import com.uploadFile.uploadFile.model.dto.FolderDto;
import com.uploadFile.uploadFile.model.dto.UrlDto;
import com.uploadFile.uploadFile.model.entity.ArchiveEntity;
import com.uploadFile.uploadFile.model.entity.FolderEntity;
import com.uploadFile.uploadFile.repository.ArchiveRepository;
import com.uploadFile.uploadFile.service.interfaces.ServiceInterface;
import com.uploadFile.uploadFile.session.ClientSession;
import com.uploadFile.uploadFile.util.mapper.ArchiveMapper;
import com.uploadFile.uploadFile.util.mapper.FolderMapper;
import com.uploadFile.uploadFile.util.storage.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class ArchiveService implements ServiceInterface<ArchivesDto> {
    private final FileStorageService storageService;

    private final FolderService folderService;

    private final FolderMapper mapper;
    private final ArchiveMapper archiveMapper;

    private ClientSession session;

    private final ArchiveRepository repository;


    public ArchiveService(FileStorageService storageService, FolderService folderService, FolderMapper mapper, ArchiveMapper archiveMapper, ClientSession clientSession, ArchiveRepository repository) {
        this.storageService = storageService;
        this.folderService = folderService;
        this.mapper = mapper;
        this.archiveMapper = archiveMapper;
        this.session = clientSession;
        this.repository = repository;
    }

    public void saveFile(MultipartFile file) throws IOException {
        ArchivesDto archive = storageService.storeFile(session.getSession().getFolder().getIdentifier(), file);
        System.out.println("Log archive " +archive);


//        System.out.println("Testing folder " + folder);

//        System.out.println("Testing ");
//        archive.setFolder(folder);
//        System.out.println("Testing ");
//
        //     archive.setFolder(mapper.convertToDto(folderService.searchFolderClient(session.getSession().getFolder().getIdentifier())));
//
//        List<ArchivesDto> archiveDtos = new ArrayList<>();
//        archiveDtos.add(archive);
//        archive.getFolder().setClientArchives(archiveDtos);
//
        archive.setUrl(new UrlDto(archive.getName(), FileVisibility.PUBLIC));
        save(archive);
    }

    @Override
    public void save(ArchivesDto dto) {
        System.out.println("Testing dto " +dto );
        ArchiveEntity entity = archiveMapper.convertToEntity(dto);
        FolderEntity folderEntity = folderService.searchFolderClient(session.getSession().getFolder().getIdentifier());
        System.out.println("testing folder" + folderEntity);
        entity.setFolder(folderEntity);

        System.out.println("Ultimo teste: " + entity);
        repository.save(entity);
    }

    @Override
    public void delete(ArchivesDto dto) {

    }

    @Override
    public ArchivesDto update(ArchivesDto dto) {
        return null;
    }
}
