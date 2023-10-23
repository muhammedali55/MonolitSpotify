package com.muhammet.MonolitSpotify.repository;

import com.muhammet.MonolitSpotify.dto.response.FindAllUserProfileResponseDto;
import com.muhammet.MonolitSpotify.repository.entity.UserProfile;
import com.muhammet.MonolitSpotify.repository.view.VwUserProfile;
import com.muhammet.MonolitSpotify.utility.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * DİKKAT!!!!
 * Spring 3.X ile birlikte Respository sınıfların üzerinde eklene @Repository anotasonu kaldırılmıştır.
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
    /**
     *
     *  userName -> UserName-> kullanıcıAdı-> Kullanıcı
     *  DİKKAT!!!!!
     *  Spring Data Jpa içinde belli kelimeleri analiz ederek doğru sırlamalada kullanıldığında
     *  sorgulamayı kelimerle yapabiliyor.
     *  Kelimeleri Kullanarak Sorgu Yazma Syntax' i
     *  1-> [find] yazılır
     *  2-> [By] yazılır, "belli koşullarda araya başka keywordler gelebilir."
     *  3-> [Entity - Değişken Adı], Burada Dikkat, değişken adları büyük harf ile başlamalı.
     *  4-> () parantez içine istediğiniz türdeki değişken ya da değişkenleri tanımlıyorsunuz.
     *
     */
    UserProfile findByResimUrl(String bak_simdi_buraya_resim_url_si_vereceksin);
  //  Optional<UserProfile> findOptionalByUserName(String userName);
    // select * from tbl_userprofile where state = ?
    List<UserProfile> findAllByState(State state);

    /**
     * select * from tbl_userprofile where createAt > now()-1000*60*60*24*30
     * son [X günde] kayıt olanların listesi
     * GreaterThan -> bundan büyük ->  createAt > XXX
     * LessThan -> bundan küçük  createAt < XXX
     * GreaterThanEquals ->  createAt >= XXX
     * LessThanEquals ->  createAt <= XXX
     *
     */
    List<UserProfile> findAllByCreateAtGreaterThan(Long kayitZamani);

    /**
     * select * from tbl_userprofile where username like '%muh%'
     * DİKKAT!!!!!
     * burada username ile parametre gönderirken gelen değere spring % ya da _ gibi
     * operatörleri eklemez. Bu nedenle sorgu yaparken şu şekilde kullanın
     *  -> findAllByUserNameLike("%muh%");
     */
    List<UserProfile> findAllByUserNameLike(String username);


    /**
     *
     * select * from tbl_userprofile where username = muh%
     */
    List<UserProfile> findAllByUserNameStartingWith(String userName);

    /**
     *
     * select * from tbl_userprofile where createAt>XXX and username like 'muh%'
     * And
     * Or
     */
    List<UserProfile> findAllByCreateAtGreaterThanAndUserNameLike(Long lastDate,String userName);

    /**
     *
     * Optional
     *
     */
    Optional<UserProfile> findOptionalByUserName(String userName);

    /**
     *
     * Sıralama çok önemli olabiliyor.
     * select * from tbluserprofile order by createAt [ASC,DESC]
     * ASC -> A....Z
     * DESC -> Z...A
     */
    List<UserProfile> findAllByOrderByCreateAt();
    List<UserProfile> findAllByOrderByCreateAtDesc();

    /**
     *
     * Belli kayıtların öncelenerek çekilmesi ya da kayıtlarda kısıtlamaya gidilmesi
     * listelenirken performas sağlar ve çok daha anlanmlıdır.
     */
    List<UserProfile>  findTop3By();
    List<UserProfile>  findTop10ByOrderByCreateAtDesc();
    UserProfile findTopByOrderByCreateAtDesc();
    Optional<UserProfile> findTopOptionalByOrderByCreateAtDesc();


    /**
     *
     * Belli aralıklarda kısıtlamaya gidebiliriz. bunun için and ile birleştirme yapabiliriz.
     * ancak Spring data bunun için bize bir kolaylık sağlıyor.
     * üyelik tarihi 1 ile 2 yıl arasında olanları getir.
     */
    List<UserProfile> findAllByCreateAtBetween(Long start,Long end);
    List<UserProfile> findAllByUserNameLikeAndCreateAtBetween(String userName,Long start,Long end);

    /**
     *
     * -> isActive = true/false
     * List<UserProfile> findAllByIsActive(boolean isActive);
     * List<UserProfile> findAllByIsActiveTrue();
     * List<UserProfile> findAllByIsActiveFalse();
     */

    /**
     *
     * Bir alanı sorgularken eşitlik için ek bir kodlama yapmaya gerek yoktur. ancak, bazen
     * girilen değer ile tutulmış olan değer büyük küçük harf sorununa takılabilir bunun için
     * bu işlemi ignore etmek gerekebilir.
     */
    Optional<UserProfile> findOptionalByUserNameIgnoreCase(String username);

    /**
     *
     * Bazı kolonlar belki daha sonra doldurulmak üzere boş bırakılabilirler bu nedenle
     * kontrol etmek ve kullanıcıya bunları doldurası yönünde telkinde bulunabiliriz.
     * Null, IsNull, NotNull,
     *
     */
    List<UserProfile> findAllByResimUrlIsNull();


    /**
     *
     * Spring Data Jpa kolaylık açısında kendi kelimelerini desteklsede daha karmaşık sorgular ve
     * yapılar için özel sorgu yazabilmenize de olanak tanımaktadır;
     * Bu işlemler için 3 farklı yöntem vardır:
     * 1-JPQL
     * 2-HQL
     * 3-NativeSQL
     *
     */
    @Query("select u from UserProfile u where u.resimUrl IS NULL and u.userName= ?1 and u.createAt> ?2")
    UserProfile egerKullanicininResmiYokIseVeAdiMuhammetIseBul(String userName, Long createAt);

    @Query("select new com.muhammet.MonolitSpotify.repository.view.VwUserProfile(u.id,u.userName,u.resimUrl) from UserProfile u")
    List<VwUserProfile> findAllFromUserProfileView();

//    @Query("select new com.muhammet.MonolitSpotify.dto.response.FindAllUserProfileResponseDto(u.id,u.userName,u.resimUrl) from UserProfile u")
//    List<FindAllUserProfileResponseDto> findAllFromUserProfile();


}
