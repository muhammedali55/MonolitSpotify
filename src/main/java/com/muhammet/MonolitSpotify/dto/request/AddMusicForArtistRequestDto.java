package com.muhammet.MonolitSpotify.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddMusicForArtistRequestDto {
    @NotNull
    @Min(1)
    Long musicId;
    @NotNull
    @Min(1)
    Long artistId;
}
