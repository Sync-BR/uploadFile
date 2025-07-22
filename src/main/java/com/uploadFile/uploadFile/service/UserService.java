package com.uploadFile.uploadFile.service;

import com.uploadFile.uploadFile.details.CustomUserDetails;
import com.uploadFile.uploadFile.details.CustomUserDetailsService;
import com.uploadFile.uploadFile.model.dto.ClientDto;
import com.uploadFile.uploadFile.model.entity.ClientEntity;
import com.uploadFile.uploadFile.repository.ClientRepository;

import com.uploadFile.uploadFile.session.ClientSession;
import com.uploadFile.uploadFile.util.validate.user.LoginValid;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final LoginValid validator;
    private final ClientRepository repository;
    private final ClientSession session;
    private final CustomUserDetailsService userDetailsService;

    public UserService(LoginValid validator, ClientRepository repository, ClientSession session, CustomUserDetailsService userDetailsService) {
        this.validator = validator;
        this.repository = repository;
        this.session = session;
        this.userDetailsService = userDetailsService;
    }

    public void login(ClientDto dto) {
        ClientEntity searchClient = repository.findByEmailAndUser_Password(
                dto.getClientEmail(),
                dto.getClientUser().getPassword()
        );
        validator.validate(searchClient);
        session.setSession(searchClient);
        System.out.println("Log login: "+searchClient);


        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                searchClient,
                null,
                null
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

}
