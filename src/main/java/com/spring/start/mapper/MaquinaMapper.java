package com.spring.start.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.spring.start.dto.cliente.ClienteResponseDto;
import com.spring.start.dto.maquina.MaquinaRequestDto;
import com.spring.start.dto.maquina.MaquinaResponseDto;
import com.spring.start.dto.recaudacion.RecaudacionResponseDto;
import com.spring.start.entity.Cliente;
import com.spring.start.entity.Maquina;
import com.spring.start.entity.Recaudacion;

@Mapper(componentModel = "spring")
public interface MaquinaMapper {

	public MaquinaResponseDto mapToMaquinaResponseDto(Maquina maquina);

	public List<MaquinaResponseDto> mapToMaquinaResponseDto(List<Maquina> maquinas);

	public Maquina mapMaquinaRequestToMaquina(MaquinaRequestDto dto);

	public Maquina mapMaquinaRequestToMaquina(Long id, MaquinaRequestDto dto);

	public MaquinaResponseDto mapMaquinaRequestToMaquinaResponse(MaquinaRequestDto dto);

	public List<RecaudacionResponseDto> mapToRecaudacionResponseDto(List<Recaudacion> recaudaciones);

	public ClienteResponseDto mapToClienteResponseDto(Cliente cliente);
}
