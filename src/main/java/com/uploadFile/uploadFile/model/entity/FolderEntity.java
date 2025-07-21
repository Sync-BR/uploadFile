package com.uploadFile.uploadFile.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "FOLDER")
@Getter
@Setter
@ToString
public class FolderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String identifier;

//    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ArchiveEntity> archives = new ArrayList<>();


    public FolderEntity() {
    }

    public FolderEntity(String identifier) {
        this.identifier = identifier;
    }
//
//    public FolderEntity(String identifier, List<ArchiveEntity> archives) {
//        this.identifier = identifier;
//        this.archives = archives;
//    }
}
