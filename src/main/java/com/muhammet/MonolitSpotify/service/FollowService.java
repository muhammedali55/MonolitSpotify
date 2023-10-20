package com.muhammet.MonolitSpotify.service;

import com.muhammet.MonolitSpotify.repository.FollowRepository;
import com.muhammet.MonolitSpotify.repository.entity.Follow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository repository;

    public void save(Follow entity){
        repository.save(entity);
    }
}
