package com.spring.start.mapper;

import org.mapstruct.Mapper;

import com.spring.start.dto.tiene.TieneKeyRequestDto;
import com.spring.start.entity.TieneKey;

@Mapper(componentModel = "spring")
public interface TieneKeyMapper {

	public TieneKey mapTieneKeyRequestDtoToTieneKey(TieneKeyRequestDto dto);
}
