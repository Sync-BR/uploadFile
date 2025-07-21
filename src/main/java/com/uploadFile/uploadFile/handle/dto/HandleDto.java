package com.uploadFile.uploadFile.handle.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class HandleDto {
    private LocalDate timestamp;
    private int status;
    private String message;
    private String path;

    public HandleDto(int status, String message, String path) {
        timestamp = LocalDate.now();
        this.status = status;
        this.message = message;
        this.path = path;
    }
}
