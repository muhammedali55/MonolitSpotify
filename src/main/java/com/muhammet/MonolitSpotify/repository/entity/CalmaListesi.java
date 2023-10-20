package com.muhammet.MonolitSpotify.repository.entity;

import com.muhammet.MonolitSpotify.utility.enums.State;
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
@Table(name = "tbl_calma_listesi")
public class CalmaListesi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userProfileId;
    String baslik;
    int sarkiSayisi;
    @Enumerated(EnumType.STRING)
    State state;
}
