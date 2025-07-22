package com.uploadFile.uploadFile.service.OAuth2;

import com.uploadFile.uploadFile.model.dto.ClientDto;
import com.uploadFile.uploadFile.repository.ClientRepository;
import com.uploadFile.uploadFile.session.ClientSession;
import com.uploadFile.uploadFile.util.mapper.ClientMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientOAuth2Service {
    private final ClientSession session;
    private final ClientMapper mapper;
    private final ClientRepository repository;

    public ClientOAuth2Service(ClientSession session, ClientMapper mapper, ClientRepository repository) {
        this.session = session;
        this.mapper = mapper;
        this.repository = repository;
    }


    public void createOrGetClientFromOAuth(String name, String email, String phone) {
        ClientDto oAuth2Dto = new ClientDto(name, email, phone);
        if (repository.findByEmail(email) == null) {
            repository.save(mapper.createOAuth2ToEntity(oAuth2Dto));
        }
        session.setSession(repository.findByEmail(email));
    }

}
