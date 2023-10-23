package com.muhammet.MonolitSpotify.mapper;

import com.muhammet.MonolitSpotify.dto.request.SaveMuzikRequestDto;
import com.muhammet.MonolitSpotify.repository.entity.Muzik;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * componentModel -> Mapper in bu sınıftan bir nesne yaratmakla ilgili yapısının spring model şeklinde
 * olduğunu belirtiyoruz.
 * unmappedTargetPolicy -> eğer atama yapılacak olan sınıf içindeki alanlar kaynak nesne ile uyuşmıyor
 * ise hata vermemesi uyuşmayan alanları ignore etmesi(null geçmesi) için kullanılır.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MuzikMapper {
    /**
     * İlgili sınıftan bir impl yaratarak nesnenin referansını INSTANCE a atar. yani size bir nesne döner.
     */
    MuzikMapper INSTANCE = Mappers.getMapper(MuzikMapper.class);

//    @Mappings({
//            @Mapping(target = "",source = ""),
//            @Mapping(target = "",source = ""),
//            @Mapping(target = "",source = "")
//    })
    Muzik muzikFromDto(final SaveMuzikRequestDto dto);
}
