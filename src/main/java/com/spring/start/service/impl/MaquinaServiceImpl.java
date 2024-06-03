package com.spring.start.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.start.dto.maquina.MaquinaDataIngresosDTO;
import com.spring.start.dto.maquina.MaquinaRequestDto;
import com.spring.start.dto.maquina.MaquinaResponseDto;
import com.spring.start.entity.Maquina;
import com.spring.start.mapper.MaquinaMapper;
import com.spring.start.repository.ClienteRepository;
import com.spring.start.repository.MaquinaRepository;
import com.spring.start.service.MaquinaService;

@Service
public class MaquinaServiceImpl implements MaquinaService {

	@Autowired
	private MaquinaRepository maquinaRepository;

	@Autowired
	private MaquinaMapper maquinaMapper;
	
	@Autowired
	private ClienteRepository clienteRepository;

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
		
		if(!clienteRepository.existsById(dto.getIdCliente())) {
			throw new IllegalArgumentException("Ese cliente no existe");
		}
		
		maquina.setCliente(clienteRepository.findById(dto.getIdCliente()).get());
		
		maquinaRepository.save(maquina);
		return maquinaMapper.mapMaquinaRequestToMaquinaResponse(dto);
	}

	@Override
	public void delete(Long id) {
		if (!maquinaRepository.existsById(id)) {
			throw new IllegalArgumentException("No existe esa maquina");
		}
		desvincularCliente(id);
		maquinaRepository.deleteById(id);
	}

	@Override
	public List<MaquinaDataIngresosDTO> findByIngresos() {
		return maquinaRepository.findByNombreGroupByIngresos();
	}

	@Override
	public void desvincularCliente(long id) {
		Optional<Maquina> maquinaOptional = maquinaRepository.findById(id);
		if (maquinaOptional.isEmpty()) {
			throw new IllegalArgumentException("Esa maquina no existe");
		}
		Maquina maquina = maquinaOptional.get();
		if (maquina.getCliente() != null) {
			List<Maquina> maquinas = maquina.getCliente().getMaquinas();

			maquinas.remove(maquina);
			maquina.setCliente(null);

			maquinaRepository.save(maquina);
		}
	}

	@Override
	public void almacenarMaquina(long id) {
		Optional<Maquina> maquinaOptional = maquinaRepository.findById(id);
		if (maquinaOptional.isEmpty()) {
			throw new IllegalArgumentException("Esa maquina no existe");
		}
		Maquina maquina = maquinaOptional.get();
		maquina.setAlmacenada(!maquina.getAlmacenada());
		maquinaRepository.save(maquina);
	}
}
