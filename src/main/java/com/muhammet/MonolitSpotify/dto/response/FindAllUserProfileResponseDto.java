package com.muhammet.MonolitSpotify.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FindAllUserProfileResponseDto {
    Long id;
    String userName;
    String resimUrl;
}
