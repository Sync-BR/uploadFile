package com.uploadFile.uploadFile.controller.routes;

import com.uploadFile.uploadFile.model.dto.ArchivesDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/home")
    public String index(Model model){
        model.addAttribute("archive", new ArchivesDto());
        return "/user/index";
    }
}
