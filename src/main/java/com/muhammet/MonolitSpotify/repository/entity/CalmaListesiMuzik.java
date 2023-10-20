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
@Table(name = "tbl_calmalistesi_muzik")
public class CalmaListesiMuzik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long muzikId;
    Long calmaListesiId;
    @Enumerated(EnumType.STRING)
    State state;
}
