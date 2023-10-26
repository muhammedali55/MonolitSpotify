package com.muhammet.MonolitSpotify.service;

import com.muhammet.MonolitSpotify.dto.request.SaveUserProfileRequestDto;
import com.muhammet.MonolitSpotify.dto.response.FindAllUserProfileResponseDto;
import com.muhammet.MonolitSpotify.exception.ErrorType;
import com.muhammet.MonolitSpotify.exception.MonolitSpotifyException;
import com.muhammet.MonolitSpotify.repository.UserProfileRepository;
import com.muhammet.MonolitSpotify.repository.entity.UserProfile;
import com.muhammet.MonolitSpotify.utility.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * DİKKAT!!!!!
 * servis sınıflarının belirtilmesi ve bunlardan birere Bean oluşturulması için spring bu sınıfların
 * üzesrinde @Service anotasyonu olup olmadığına bakar. eğer boş geçilirse hata fırlatır ve uygulamanız
 * ayağa kalkmaz.
 */
@Service
@RequiredArgsConstructor
public class UserProfileService {

    /**
     * DİKKAT!!!!!
     * Spring Bean olorak işaretlediği (@Repository, @Service, @Configuration, @Component v.s.)
     * tüm sınıflardan nesne yaratabilmek için 3 farklı yöntem izler
     * 1- Değişkenin üzerinde @Autowired ekleyerek
     * 2- Değişkenin constructor a parametre olarak geçilmesi ile yapılır.(constructor injection)
     * 3- 2. yöntem in 3. taraf uygulamalar ile sağlanması. yazımı daha kolaydır. kod sayfasının
     * dha temiz görünmesini sağlar.
     */

    //    @Autowired
    //    private UserProfileRepository repositoryYontem_1;

    //    private final UserProfileRepository repositoryYontem_2;
    //
    //    public UserProfileService(UserProfileRepository repositoryYontem_2){
    //       this.repositoryYontem_2 = repositoryYontem_2;
    //    }
    private final UserProfileRepository repository;

    public void save(UserProfile userProfile){
        /**
         * ÖNEMLİ!!!!
         * save işlemi iki şekilde çalışır;
         * 1- Eğer kendisine veerilen nesne id bilgisini içermiyor ise
         * yani null ise kaydetme işlemi yapar.
         * 2- Eğer nesne içindeki id bir değer içeriyor ise bu seferde
         * güncelleme işlemi yapar.
         */
        repository.save(userProfile);
    }

    public void save(SaveUserProfileRequestDto dto){
        if(!dto.getPassword().equals(dto.getRePassword()))
            throw new MonolitSpotifyException(ErrorType.SIFRE_UYUSMUYOR);
        if(repository.existsByUserName(dto.getUserName()))
            throw new MonolitSpotifyException(ErrorType.KAYITLI_KULLANICI_ADI);
        UserProfile userProfile = UserProfile.builder()
                .userName(dto.getUserName())
                .userType(dto.getUserType())
                .createAt(System.currentTimeMillis())
                .updateAt(System.currentTimeMillis())
                .resimUrl(dto.getResimUrl())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .state(State.ACTIVE)
                .build();
        repository.save(userProfile);
    }

    public List<UserProfile> findAll(){
        return repository.findAll();
    }


    public FindAllUserProfileResponseDto findAllUserProfile() {
        return FindAllUserProfileResponseDto.builder()
                .statusCode(100)
                .message("Listeler başarı şekilde çekildi")
                .data(repository.findAllFromUserProfileView())
                .build();
    }

}
