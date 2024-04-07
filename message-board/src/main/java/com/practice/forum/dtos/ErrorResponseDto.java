package com.practice.forum.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorResponseDto {
    private String status;
    private String error;
    private String message;
    private String path;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss a z")
    private Date timestamp;

    public ErrorResponseDto(Exception exception, HttpServletRequest request) {
        this.error = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.path = request.getRequestURI();
        this.timestamp = new Date();
    }
}
