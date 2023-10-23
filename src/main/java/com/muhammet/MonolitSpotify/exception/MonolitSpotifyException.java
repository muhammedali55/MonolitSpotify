package com.muhammet.MonolitSpotify.exception;

import lombok.Getter;

@Getter
public class MonolitSpotifyException extends RuntimeException{
    private final ErrorType errorType;

    public MonolitSpotifyException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public MonolitSpotifyException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
