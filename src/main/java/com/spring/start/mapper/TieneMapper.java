package com.spring.start.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.spring.start.dto.tiene.TieneKeyRequestDto;
import com.spring.start.dto.tiene.TieneResponseDto;
import com.spring.start.entity.Tiene;

@Mapper(componentModel = "spring")
public interface TieneMapper {

	public List<TieneResponseDto> mapToTieneResponseDto(List<Tiene> tienes);

	public Tiene mapTieneRequestDtoToTiene(TieneKeyRequestDto dto);

	public TieneResponseDto mapTieneRequestDtoToTieneResponseDto(TieneKeyRequestDto dto);
}
