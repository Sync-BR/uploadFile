package com.uploadFile.uploadFile.service;

import com.uploadFile.uploadFile.model.entity.ClientEntity;
import com.uploadFile.uploadFile.repository.ClientRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
@Service
public class UserAuthService implements UserDetailsService {

    private final HttpServletRequest request;
    private final ClientRepository repository;

    public UserAuthService(HttpServletRequest request, ClientRepository repository) {

        this.request = request;
        this.repository = repository;
    }

    public void authenticateUser(String email, String password) {
        ClientEntity client = repository.findByEmail(email);
        if (client == null || !client.getUser().getPassword().equals(password)) {
            throw new UsernameNotFoundException("Credenciais inválidas");
        }
        UserDetails userDetails = this.loadUserByUsername(email);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        request.getSession().setAttribute(
                "SPRING_SECURITY_CONTEXT",
                SecurityContextHolder.getContext()
        );
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClientEntity client = repository.findByEmail(username);
        return org.springframework.security.core.userdetails.User
                .withUsername(client.getEmail())
                .password(client.getUser().getPassword())
                .authorities(getAuthorities(client))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();

    }

    private Collection<? extends GrantedAuthority> getAuthorities(ClientEntity client) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
