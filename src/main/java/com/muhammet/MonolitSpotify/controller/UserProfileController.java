package com.muhammet.MonolitSpotify.controller;

import com.muhammet.MonolitSpotify.repository.entity.UserProfile;
import com.muhammet.MonolitSpotify.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userprofile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping("/save")
    public ResponseEntity<UserProfile> save(String userName, String name,String email,String phone){
        UserProfile userProfile = UserProfile.builder()
                .userName(userName)

                .build();
        userProfileService.save(userProfile);
        return ResponseEntity.ok(userProfile);
    }


    @GetMapping("/findall")
    public ResponseEntity<List<UserProfile>> findAll(){
        return ResponseEntity.ok(userProfileService.findAll());
    }



}
