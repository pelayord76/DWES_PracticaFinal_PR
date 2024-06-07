package com.spring.start.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.start.dto.recaudacion.RecaudacionRequestDto;
import com.spring.start.dto.recaudacion.RecaudacionResponseDto;
import com.spring.start.entity.Recaudacion;
import com.spring.start.mapper.RecaudacionMapper;
import com.spring.start.repository.MaquinaRepository;
import com.spring.start.repository.RecaudacionRepository;
import com.spring.start.service.RecaudacionService;

@Service
public class RecaudacionServiceImpl implements RecaudacionService {

	@Autowired
	private RecaudacionRepository recaudacionRepository;

	@Autowired
	private RecaudacionMapper recaudacionMapper;

	@Autowired
	private MaquinaRepository maquinaRepository;

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
		Recaudacion recaudacion = recaudacionMapper.mapRecaudacionRequestToRecaudacion(dto);
		recaudacion.setMaquina(maquinaRepository.findById(dto.getMaquina().getId()).get());
		recaudacionRepository.save(recaudacion);
		return recaudacionMapper.mapToRecaudacionResponseDto(recaudacion);
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
		desvincularMaquina(id);
		recaudacionRepository.deleteById(id);
	}

	@Override
	public void desvincularMaquina(long id) {
		Optional<Recaudacion> recaudacionOptional = recaudacionRepository.findById(id);
		if (recaudacionOptional.isEmpty()) {
			throw new IllegalArgumentException("No existe esa recaudación");
		}
		Recaudacion recaudacion = recaudacionOptional.get();
		if (recaudacion.getMaquina() != null) {
			List<Recaudacion> recaudaciones = recaudacion.getMaquina().getRecaudaciones();

			recaudaciones.remove(recaudacion);
			recaudacion.setMaquina(null);

			recaudacionRepository.save(recaudacion);
		}
	}
}
