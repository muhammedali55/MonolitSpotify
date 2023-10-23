package com.muhammet.MonolitSpotify.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MonolitSpotifyException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleMonolitSpotifyException(MonolitSpotifyException exception){
        return ResponseEntity.ok(ErrorMessage.builder()
                        .code(exception.getErrorType().getCode())
                        .message(exception.getErrorType().getMessage())
                .build());
    }
}
