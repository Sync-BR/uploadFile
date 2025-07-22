package com.uploadFile.uploadFile.repository;

import com.uploadFile.uploadFile.model.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    ClientEntity findByEmail(String email);
    ClientEntity findByPhone(String phone);

    ClientEntity findByEmailAndUser_Password(String email, String password);

    ClientEntity findByFolder_Identifier(String folder_Identifier);


}
