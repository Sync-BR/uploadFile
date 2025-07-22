package com.uploadFile.uploadFile.controller.routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UploadController {

    @GetMapping("/archives")
    public String index(){
        return "/archives/index";
    }


}
