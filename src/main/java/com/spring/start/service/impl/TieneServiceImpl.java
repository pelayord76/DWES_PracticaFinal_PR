package com.spring.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.start.dto.tiene.TieneKeyRequestDto;
import com.spring.start.dto.tiene.TieneResponseDto;
import com.spring.start.entity.Tiene;
import com.spring.start.entity.TieneKey;
import com.spring.start.mapper.TieneKeyMapper;
import com.spring.start.mapper.TieneMapper;
import com.spring.start.repository.TieneRepository;
import com.spring.start.service.TieneService;

@Service
public class TieneServiceImpl implements TieneService {

	@Autowired
	private TieneRepository tieneRepository;

	@Autowired
	private TieneMapper tieneMapper;

	@Autowired
	private TieneKeyMapper tieneKeyMapper;

	@Override
	public List<TieneResponseDto> findAll() {
		List<Tiene> tienes = tieneRepository.findAll();
		return tieneMapper.mapToTieneResponseDto(tienes);
	}

	@Override
	public TieneResponseDto add(TieneKeyRequestDto dto) {
		tieneRepository.save(tieneMapper.mapTieneRequestDtoToTiene(dto));
		return tieneMapper.mapTieneRequestDtoToTieneResponseDto(dto);
	}

	@Override
	public void delete(TieneKeyRequestDto dto) {
		TieneKey id = tieneKeyMapper.mapTieneKeyRequestDtoToTieneKey(dto);
		if (!tieneRepository.findById(id).isPresent()) {
			throw new IllegalArgumentException("No existe una relacion con esos campos");
		}
		tieneRepository.deleteById(id);
	}
}
