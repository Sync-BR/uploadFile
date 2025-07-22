package com.uploadFile.uploadFile.util.storage;

import com.uploadFile.uploadFile.model.dto.ArchivesDto;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    private Path rootLocation;

    public FileStorageService(@Value("${file.upload-dir}") String uploadDir) {
        this.rootLocation = Paths.get(uploadDir);
    }


    public ArchivesDto storeFile(String folderIdentifier, MultipartFile file) throws IOException {
// Cria pasta se não existir
        Path folderPath = rootLocation.resolve(folderIdentifier);
        Files.createDirectories(folderPath);

        String originalFileName = file.getOriginalFilename();
        String fileName = originalFileName;
        Path destinationFile = folderPath.resolve(fileName).normalize().toAbsolutePath();

        // Se arquivo existe, altera o nome
        int count = 1;
        while (Files.exists(destinationFile)) {
            fileName = appendSuffixToFileName(originalFileName, count++);
            destinationFile = folderPath.resolve(fileName).normalize().toAbsolutePath();
        }

        Files.copy(file.getInputStream(), destinationFile);

        return new ArchivesDto(fileName, folderPath.toString(), Files.size(destinationFile), null, null );
    }




    private String appendSuffixToFileName(String fileName, int count) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex == -1) {
            return fileName + "(" + count + ")";
        } else {
            String name = fileName.substring(0, dotIndex);
            String extension = fileName.substring(dotIndex);
            return name + "(" + count + ")" + extension;
        }
    }
}
