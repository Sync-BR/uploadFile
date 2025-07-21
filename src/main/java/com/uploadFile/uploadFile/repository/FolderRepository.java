package com.uploadFile.uploadFile.repository;

import com.uploadFile.uploadFile.model.entity.FolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<FolderEntity,Long> {
    FolderEntity findByIdentifier(String identifier);
}
