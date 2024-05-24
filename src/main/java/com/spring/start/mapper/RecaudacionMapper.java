package com.spring.start.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.spring.start.dto.recaudacion.RecaudacionRequestDto;
import com.spring.start.dto.recaudacion.RecaudacionResponseDto;
import com.spring.start.entity.Recaudacion;

@Mapper(componentModel = "spring")
public interface RecaudacionMapper {

	public RecaudacionResponseDto mapToRecaudacionResponseDto(Recaudacion recaudacion);

	public List<RecaudacionResponseDto> mapToRecaudacionResponseDto(List<Recaudacion> recaudacions);

	public Recaudacion mapRecaudacionRequestToRecaudacion(RecaudacionRequestDto dto);

	public Recaudacion mapRecaudacionRequestToRecaudacion(Long id, RecaudacionRequestDto dto);

	public RecaudacionResponseDto mapRecaudacionRequestToRecaudacionResponse(RecaudacionRequestDto dto);
}
