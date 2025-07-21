package com.uploadFile.uploadFile.handle;

import com.uploadFile.uploadFile.handle.dto.HandleDto;
import com.uploadFile.uploadFile.handle.exception.ResourceAlreadyExistsException;
import com.uploadFile.uploadFile.model.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationHandle {

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<HandleDto> handleResourceAlreadyExists(ResourceAlreadyExistsException ex, HttpServletRequest request) {
        HandleDto response = new HandleDto(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
