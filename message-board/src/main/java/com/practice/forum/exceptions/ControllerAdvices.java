package com.practice.forum.exceptions;

import com.practice.forum.dtos.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler({
            UserNotFoundException.class,
            ForumNotFoundException.class,
            ThreadNotFoundException.class,
            PostNotFoundException.class
    })
    public ResponseEntity<ErrorResponseDto> handleNotFoundExceptions(Exception exception, HttpServletRequest request) {
        ErrorResponseDto responseDto = new ErrorResponseDto(exception, request);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        responseDto.setStatus(httpStatus.toString());

        return new ResponseEntity<ErrorResponseDto>(responseDto, httpStatus);
    }

    @ExceptionHandler(
            Exception.class
    )
    public ResponseEntity<ErrorResponseDto> handleDefaultExceptions(Exception exception, HttpServletRequest request) {
        ErrorResponseDto responseDto = new ErrorResponseDto(exception, request);
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        responseDto.setStatus(httpStatus.toString());

        return new ResponseEntity<ErrorResponseDto>(responseDto, httpStatus);
    }
}
