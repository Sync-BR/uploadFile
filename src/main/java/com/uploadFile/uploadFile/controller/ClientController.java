package com.uploadFile.uploadFile.controller;

import com.uploadFile.uploadFile.handle.exception.ResourceAlreadyExistsException;
import com.uploadFile.uploadFile.model.dto.ClientDto;
import com.uploadFile.uploadFile.service.ClientService;
import com.uploadFile.uploadFile.service.UserAuthService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClientController {
    private final ClientService service;
    private final UserAuthService userAuthService;

    public ClientController(ClientService service, UserAuthService userAuthService) {
        this.service = service;
        this.userAuthService = userAuthService;
    }

    @PostMapping("/v1/client/register")
    public String register(@ModelAttribute("client") ClientDto dto, RedirectAttributes redirectAttributes) {
        try {
            service.save(dto);
            return "redirect:/registrar?success";
        } catch (ResourceAlreadyExistsException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/registrar?error";
        }
    }

    @PostMapping("/v1/client/login")
    public String login(@ModelAttribute("user") ClientDto dto,
                        RedirectAttributes redirectAttributes) {
        try {
            userAuthService.authenticateUser(dto.getClientEmail(), dto.getClientUser().getPassword());
            return "redirect:/home";
        } catch (UsernameNotFoundException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/login?error";
        }
    }


}
