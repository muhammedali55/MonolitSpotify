package com.muhammet.MonolitSpotify.dto.response;

import com.muhammet.MonolitSpotify.repository.entity.Muzik;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FindAllMuzikResponseDto {
    int statusCode;
    String message;
    List<Muzik> data;
}
