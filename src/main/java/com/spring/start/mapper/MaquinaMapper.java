package com.spring.start.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.spring.start.dto.maquina.MaquinaRequestDto;
import com.spring.start.dto.maquina.MaquinaResponseDto;
import com.spring.start.entity.Maquina;

@Mapper(componentModel = "spring")
public interface MaquinaMapper {

	public MaquinaResponseDto mapToMaquinaResponseDto(Maquina maquina);

	public List<MaquinaResponseDto> mapToMaquinaResponseDto(List<Maquina> maquinas);

	public Maquina mapMaquinaRequestToMaquina(MaquinaRequestDto dto);

	public Maquina mapMaquinaRequestToMaquina(Long id, MaquinaRequestDto dto);

	public MaquinaResponseDto mapMaquinaRequestToMaquinaResponse(MaquinaRequestDto dto);
}
