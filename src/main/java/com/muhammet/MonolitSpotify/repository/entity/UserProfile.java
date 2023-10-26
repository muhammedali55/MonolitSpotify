package com.muhammet.MonolitSpotify.repository.entity;

import com.muhammet.MonolitSpotify.utility.enums.State;
import com.muhammet.MonolitSpotify.utility.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_userprofile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String userName;
    String resimUrl;
    String password;
    String email;
    int followerCount;
    int folowingCount;
    Long createAt;
    Long updateAt;
    @Enumerated(EnumType.STRING)
    UserType userType;
    @Enumerated(EnumType.STRING)
    State state;
}
