package com.uploadFile.uploadFile.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "CLIENT")
@Getter
@Setter
@ToString
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "folder_id", referencedColumnName = "id")
    private FolderEntity folder;

    public ClientEntity() {

    }

    public ClientEntity(String name, String email, String phone, UserEntity user, FolderEntity folder) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.user = user;
        this.folder = folder;
    }
}
