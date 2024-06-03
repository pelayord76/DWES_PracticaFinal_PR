package com.spring.start.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.start.dto.cliente.ClienteLocalResponseDto;
import com.spring.start.dto.recaudacion.RecaudacionRequestDto;
import com.spring.start.dto.recaudacion.RecaudacionResponseDto;
import com.spring.start.entity.Recaudacion;
import com.spring.start.mapper.RecaudacionMapper;
import com.spring.start.repository.RecaudacionRepository;
import com.spring.start.service.RecaudacionService;

@Service
public class RecaudacionServiceImpl implements RecaudacionService {

	@Autowired
	private RecaudacionRepository recaudacionRepository;

	@Autowired
	private RecaudacionMapper recaudacionMapper;

	@Override
	public RecaudacionResponseDto findById(Long id) {
		Optional<Recaudacion> recaudacionOptional = recaudacionRepository.findById(id);
		if (recaudacionOptional.isEmpty()) {
			throw new IllegalArgumentException("Esa recaudacion no existe");
		}
		return recaudacionMapper.mapToRecaudacionResponseDto(recaudacionOptional.get());
	}

	@Override
	public List<RecaudacionResponseDto> findAll() {
		List<Recaudacion> recaudaciones = recaudacionRepository.findAll();
		return recaudacionMapper.mapToRecaudacionResponseDto(recaudaciones);
	}

	@Override
	public RecaudacionResponseDto add(RecaudacionRequestDto dto) {
		recaudacionRepository.save(recaudacionMapper.mapRecaudacionRequestToRecaudacion(dto));
		return recaudacionMapper.mapRecaudacionRequestToRecaudacionResponse(dto);
	}

	@Override
	public RecaudacionResponseDto update(Long id, RecaudacionRequestDto dto) {
		Optional<Recaudacion> recaudacionOptional = recaudacionRepository.findById(id);
		if (recaudacionOptional.isEmpty()) {
			throw new IllegalArgumentException("Esa recaudacion no existe");
		}
		Recaudacion recaudacion = recaudacionMapper.mapRecaudacionRequestToRecaudacion(id, dto);
		recaudacionRepository.save(recaudacion);
		return recaudacionMapper.mapRecaudacionRequestToRecaudacionResponse(dto);
	}

	@Override
	public void delete(Long id) {
		if (!recaudacionRepository.existsById(id)) {
			throw new IllegalArgumentException("No existe esa recaudacion");
		}
		recaudacionRepository.deleteById(id);
	}

	@Override
	public ClienteLocalResponseDto getLocal(Long id) {
		return recaudacionRepository.getLocal(id);
	}
}
