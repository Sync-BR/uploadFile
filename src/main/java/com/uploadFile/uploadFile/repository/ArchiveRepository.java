package com.uploadFile.uploadFile.repository;

import com.uploadFile.uploadFile.model.entity.ArchiveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchiveRepository extends JpaRepository<ArchiveEntity, Long> {
    ArchiveEntity findByUrl_Url(String url);
    ArchiveEntity findByFolder_IdentifierAndUrl_Url(String folderIdentifier, String url);

}
