package com.uploadFile.uploadFile.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity(name = "FOLDER")
@Getter
@Setter
@ToString
public class FolderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String identifier;

    public FolderEntity() {
    }

    public FolderEntity(String identifier) {
        this.identifier = identifier;
    }

}
