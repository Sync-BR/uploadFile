package com.uploadFile.uploadFile.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "ARCHIVE")
@Getter
@Setter
@ToString
public class ArchiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String archiveName;
    private String archivePath;
    private long size;

    @ManyToOne()
    @JoinColumn(name = "folder_id", referencedColumnName = "id")
    private FolderEntity folder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "url_id", referencedColumnName = "id")
    private UrlEntity url;

    public ArchiveEntity() {
    }

    public ArchiveEntity(String archiveName, String archivePath, long size, FolderEntity folder, UrlEntity url) {
        this.archiveName = archiveName;
        this.archivePath = archivePath;
        this.size = size;
        this.folder = folder;
        this.url = url;
    }
}
