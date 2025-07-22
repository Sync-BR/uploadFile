package com.uploadFile.uploadFile.controller.routes;

import com.uploadFile.uploadFile.model.dto.ArchivesDto;
import com.uploadFile.uploadFile.service.DownloadService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;

@Controller
public class ShareController {

    private final DownloadService service;

    public ShareController(DownloadService downloadService){
        this.service = downloadService;
    }


    @GetMapping("/files/{id}/{url}")
    public String fileDetails(   @PathVariable String id,
                                 @PathVariable String url,
                                 Model model){
        ArchivesDto archive = service.searchArchives(id, url);
        String clientName = service.searchFolderIdentifier(id);
        model.addAttribute("file", archive);
        model.addAttribute("client", clientName);
        return "/archives/index";
    }

    @GetMapping("/files/download/{id}/{url}")
    public ResponseEntity<Resource> downloadFile(
            @PathVariable String id,
            @PathVariable String url){
        ArchivesDto archive = service.searchArchives(id, url);
        File file = new File(archive.getPath(), archive.getName());
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }
        Resource resource = new FileSystemResource(file);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + archive.getName() + "\"")
                .body(resource);
    }

}
