package com.uploadFile.uploadFile.security;

import com.uploadFile.uploadFile.service.OAuth2.ClientOAuth2Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler{

    private final ClientOAuth2Service service;

    public OAuth2LoginSuccessHandler(ClientOAuth2Service service) {
        this.service = service;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();
        service.createOrGetClientFromOAuth(oauthUser.getAttribute("name"), oauthUser.getAttribute("email"), oauthUser.getAttribute("phone"));

        response.sendRedirect("/home");
    }

}
