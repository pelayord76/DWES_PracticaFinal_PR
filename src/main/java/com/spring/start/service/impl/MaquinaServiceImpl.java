package com.spring.start.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.start.dto.maquina.MaquinaDataIngresosDTO;
import com.spring.start.dto.maquina.MaquinaRequestDto;
import com.spring.start.dto.maquina.MaquinaResponseDto;
import com.spring.start.entity.Maquina;
import com.spring.start.mapper.MaquinaMapper;
import com.spring.start.repository.MaquinaRepository;
import com.spring.start.service.MaquinaService;

public class MaquinaServiceImpl implements MaquinaService {

	@Autowired
	private MaquinaRepository maquinaRepository;

	@Autowired
	private MaquinaMapper maquinaMapper;

	@Override
	public MaquinaResponseDto findById(Long id) {
		Optional<Maquina> maquinaOptional = maquinaRepository.findById(id);
		if (maquinaOptional.isEmpty()) {
			throw new IllegalArgumentException("Esa maquina no existe");
		}
		return maquinaMapper.mapToMaquinaResponseDto(maquinaOptional.get());
	}

	@Override
	public List<MaquinaResponseDto> findAll() {
		List<Maquina> maquinas = maquinaRepository.findAll();
		return maquinaMapper.mapToMaquinaResponseDto(maquinas);
	}

	@Override
	public MaquinaResponseDto add(MaquinaRequestDto dto) {
		maquinaRepository.save(maquinaMapper.mapMaquinaRequestToMaquina(dto));
		return maquinaMapper.mapMaquinaRequestToMaquinaResponse(dto);
	}

	@Override
	public MaquinaResponseDto update(Long id, MaquinaRequestDto dto) {
		Optional<Maquina> maquinaOptional = maquinaRepository.findById(id);
		if (maquinaOptional.isEmpty()) {
			throw new IllegalArgumentException("Esa maquina no existe");
		}
		Maquina maquina = maquinaMapper.mapMaquinaRequestToMaquina(id, dto);
		maquinaRepository.save(maquina);
		return maquinaMapper.mapMaquinaRequestToMaquinaResponse(dto);
	}

	@Override
	public void delete(Long id) {
		if (!maquinaRepository.findById(id).isEmpty()) {
			throw new IllegalArgumentException("No existe esa maquina");
		}
		maquinaRepository.deleteById(id);
	}

	@Override
	public List<MaquinaDataIngresosDTO> findByIngresos() {
		// TODO Auto-generated method stub
		return null;
	}

}
