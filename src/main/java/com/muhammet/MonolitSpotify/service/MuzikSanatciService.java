package com.muhammet.MonolitSpotify.service;

import com.muhammet.MonolitSpotify.repository.MuzikRepository;
import com.muhammet.MonolitSpotify.repository.MuzikSanatciRepository;
import com.muhammet.MonolitSpotify.repository.entity.MuzikSanatci;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class MuzikSanatciService {
    private final MuzikSanatciRepository repository;
    public void save(MuzikSanatci entity){
        repository.save(entity);
    }
}
