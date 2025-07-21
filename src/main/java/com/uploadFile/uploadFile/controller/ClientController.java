package com.uploadFile.uploadFile.controller;

import com.uploadFile.uploadFile.handle.exception.LoginException;
import com.uploadFile.uploadFile.handle.exception.ResourceAlreadyExistsException;
import com.uploadFile.uploadFile.model.dto.ClientDto;
import com.uploadFile.uploadFile.service.ClientService;
import com.uploadFile.uploadFile.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {
    private final ClientService service;
    private final UserService serviceUser;

    public ClientController(ClientService service, UserService serviceUser) {
        this.service = service;
        this.serviceUser = serviceUser;
    }

    @PostMapping("/v1/client/register")
    public String register(@ModelAttribute("client")ClientDto dto){
        try{
            service.save(dto);
        } catch (ResourceAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
        return "redirect:/registrar";
    }

    @PostMapping("/v1/client/login")
    public String login(@ModelAttribute("user") ClientDto dto){
        try{
            serviceUser.login(dto);
            return "redirect:/home";
        } catch (LoginException e){
            System.out.println(e.getMessage());
        }
        return "login";
    }

}
