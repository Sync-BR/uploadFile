package com.uploadFile.uploadFile.controller;

import com.uploadFile.uploadFile.model.dto.ArchivesDto;
import com.uploadFile.uploadFile.service.ArchiveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
    private final ArchiveService service;

    public FileController(ArchiveService service) {
        this.service = service;
    }

    @PostMapping("/v1/file/upload")
    public String uploadFile(@ModelAttribute("archive") ArchivesDto archivesDto,
                             @RequestParam("file") MultipartFile file,
                             Model model) {
        try {
            service.saveFile(file);
            model.addAttribute("message", "Upload concluído com sucesso!");
        } catch (Exception e) {
            model.addAttribute("message", "Falha no upload: " + e.getMessage());
        }
        return "redirect:/home";
    }

}
