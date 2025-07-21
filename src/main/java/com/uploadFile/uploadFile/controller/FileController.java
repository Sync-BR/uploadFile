package com.uploadFile.uploadFile.controller;

import com.uploadFile.uploadFile.model.dto.ArchivesDto;
import com.uploadFile.uploadFile.service.ArchiveService;
import com.uploadFile.uploadFile.session.ClientSession;
import com.uploadFile.uploadFile.util.storage.FileStorageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
//@RequestMapping("/files")
public class FileController {
    private final ArchiveService service;
    private final ClientSession session;
    private final FileStorageService storageService;

    public FileController(ArchiveService service, ClientSession session, FileStorageService storageService) {
        this.service = service;
        this.session = session;
        this.storageService = storageService;
    }

    @PostMapping("/v1/file/upload")
    public String uploadFile(@ModelAttribute("archive") ArchivesDto archivesDto,
                             @RequestParam("file") MultipartFile file,
                             Model model) {
        try {
            service.saveFile(file);
            model.addAttribute("message", "Upload concluído com sucesso!");
          //  model.addAttribute("archive", archive);
        } catch (Exception e) {
            model.addAttribute("message", "Falha no upload: " + e.getMessage());
        }
        return "redirect:/home";
    }
}
