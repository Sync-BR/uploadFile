package com.uploadFile.uploadFile.service;

import com.uploadFile.uploadFile.model.dto.ArchivesDto;
import com.uploadFile.uploadFile.model.entity.ArchiveEntity;
import com.uploadFile.uploadFile.repository.ArchiveRepository;
import com.uploadFile.uploadFile.repository.ClientRepository;
import com.uploadFile.uploadFile.util.mapper.ArchiveMapper;
import org.springframework.stereotype.Service;

@Service
public class DownloadService {
    private final ClientRepository clientRepository;
    private final ArchiveRepository repository;
    private final ArchiveMapper mapper;

    public DownloadService(ClientRepository clientRepository, ArchiveRepository repository, ArchiveMapper mapper) {
        this.clientRepository = clientRepository;
        this.repository = repository;
        this.mapper = mapper;
    }

    public String searchFolderIdentifier(String identifier) {
        return clientRepository.findByFolder_Identifier(identifier).getName();
    }

    public ArchivesDto searchArchives(String identifier, String urlArchive)
    {
        ArchiveEntity searchArchive = repository.findByFolder_IdentifierAndUrl_Url(identifier,urlArchive);
        return mapper.convertToDto(searchArchive);
    }

}
