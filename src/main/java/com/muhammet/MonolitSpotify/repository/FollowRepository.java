package com.muhammet.MonolitSpotify.repository;

import com.muhammet.MonolitSpotify.repository.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow,Long> {
}
