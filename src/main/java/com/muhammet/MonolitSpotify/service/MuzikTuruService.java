package com.muhammet.MonolitSpotify.service;

import com.muhammet.MonolitSpotify.repository.MuzikTuruRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuzikTuruService{

    private final MuzikTuruRepository repository;

}
