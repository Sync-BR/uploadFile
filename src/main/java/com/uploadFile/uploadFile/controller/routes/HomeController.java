package com.uploadFile.uploadFile.controller.routes;

import com.uploadFile.uploadFile.model.dto.ClientDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new ClientDto());
        return "login";
    }

    @GetMapping("/registrar")
    public String register(Model model){
        model.addAttribute("client", new ClientDto());
        return "register";
    }
}
