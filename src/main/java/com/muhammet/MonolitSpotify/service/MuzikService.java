package com.muhammet.MonolitSpotify.service;

import com.muhammet.MonolitSpotify.repository.MuzikRepository;
import com.muhammet.MonolitSpotify.repository.entity.Muzik;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuzikService {
    private final MuzikRepository repository;

    public void save(Muzik entity){
        repository.save(entity);
    }

}
