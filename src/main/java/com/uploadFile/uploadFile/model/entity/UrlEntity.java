package com.uploadFile.uploadFile.model.entity;

import com.uploadFile.uploadFile.enums.FileVisibility;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "URL_FILE")
@Getter
@Setter
@ToString
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String url;
    @Enumerated(EnumType.STRING)
    private FileVisibility visibility;

    public UrlEntity() {
    }

    public UrlEntity(String url, FileVisibility visibility) {
        this.url = url;
        this.visibility = visibility;
    }
}
