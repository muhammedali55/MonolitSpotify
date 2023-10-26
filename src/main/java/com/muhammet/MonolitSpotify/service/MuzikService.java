package com.muhammet.MonolitSpotify.service;

import com.muhammet.MonolitSpotify.dto.request.AddMusicForArtistRequestDto;
import com.muhammet.MonolitSpotify.dto.request.SaveMuzikRequestDto;
import com.muhammet.MonolitSpotify.dto.response.FindAllMuzikResponseDto;
import com.muhammet.MonolitSpotify.mapper.MuzikMapper;
import com.muhammet.MonolitSpotify.repository.MuzikRepository;
import com.muhammet.MonolitSpotify.repository.entity.Muzik;
import com.muhammet.MonolitSpotify.utility.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuzikService {
    private final MuzikRepository repository;

    public void save(SaveMuzikRequestDto dto){
//        Muzik muzik = Muzik.builder()
//                .muzikUrl(dto.getMuzikUrl())
//                .aciklama(dto.getAciklama())
//                .tur(dto.getTur())
//                .name(dto.getName())
//                .sure(dto.getSure())
//                .kapakResmi(dto.getKapakResmi())
//                .build();
//        Muzik muzik = new Muzik();
//        muzik.setMuzikUrl(dto.getMuzikUrl());
//        muzik.setName(dto.getName());

       Muzik muzik = MuzikMapper.INSTANCE.muzikFromDto(dto);
       muzik.setState(State.PENDING);
       repository.save(muzik);
       // repository.save(MuzikMapper.INSTANCE.muzikFromDto(dto));
    }

    public FindAllMuzikResponseDto findAll() {
        return FindAllMuzikResponseDto.builder()
                .statusCode(100)
                .message("Müzik listesi getirildi.")
                .data(repository.findAll())
                .build();
    }

    /**
     * TODO: 1- Kullanıcı id mevcut mu bakılmalı
     * TODO: 2- Muzik id varmı kontrol edilmeli
     * TODO: 3- Kullanıcı id si verilen kişi sanatçı mı? kontrol edilecek.
     * TODO: 4- Eğer aynı kullanıcı id ve muzik id daha önce kayıt edilmiş ise tekrar kayıt edilememeli.
     *
     */
    public void addMusicForArtist(AddMusicForArtistRequestDto dto) {

    }
}
