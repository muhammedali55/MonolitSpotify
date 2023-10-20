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
@Table(name = "tbl_muzik")
public class Muzik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String muzikUrl;
    String name;
    String kapakResmi;
    /**
     * TODO: Müzik Türü tablosundan doğrulandıktan sonra girişine onay ver
     */
    String tur;
    int sure;
    String aciklama;
    @Enumerated(EnumType.STRING)
    State state;

}
