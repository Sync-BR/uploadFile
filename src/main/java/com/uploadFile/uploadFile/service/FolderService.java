package com.uploadFile.uploadFile.service;

import com.uploadFile.uploadFile.model.entity.FolderEntity;
import com.uploadFile.uploadFile.repository.FolderRepository;
import org.springframework.stereotype.Service;

@Service
public class FolderService {

    private final FolderRepository repository;

    public FolderService(FolderRepository repository) {
        this.repository = repository;
    }

    public FolderEntity searchFolderClient(String identifierFolder){
        return repository.findByIdentifier(identifierFolder);
    }

}
