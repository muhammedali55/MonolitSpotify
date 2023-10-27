package com.muhammet.MonolitSpotify.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    SIFRE_UYUSMUYOR(1001,"Girilen şifreler uyuşmuyor",HttpStatus.BAD_REQUEST),
    BAD_REQUEST_ERROR(3001,"Girilen bilgiler Hatalı, kontrol ederek tekar giriniz.", HttpStatus.BAD_REQUEST),
    KAYITLI_KULLANICI_ADI(1003,"Bu kullanıcı adı zaten kayıtlıdır",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1004,"Girilen kullanıcı id kayıtlı değildir",HttpStatus.BAD_REQUEST),
    MUSIC_NOT_FOUND(1005,"Girilen müzik id si bulunamamıştır.",HttpStatus.BAD_REQUEST),
    NO_ARTIST(1006,"Girilen kullanıcı id si bir sanatçıya ait değildir",HttpStatus.BAD_REQUEST),
    ARTIST_ERROR(1007,"Sanatçı id si hatalıdır. Lütfen tekrar kontrol sağlayarak giriş yapınız",HttpStatus.BAD_REQUEST),
    TUR_ERROR(1002,"Muzik türü bulunmadı",HttpStatus.BAD_REQUEST);

    private int code;
    private String message;
    private HttpStatus httpStatus;

//    ErrorType(int code, String message, HttpStatus httpStatus){
//        this.code = code;
//        this.httpStatus = httpStatus;
//        this.message = message;
//    }
}
