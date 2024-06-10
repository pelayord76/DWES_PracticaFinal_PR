package com.spring.start.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.start.dto.factura.FacturaRequestDto;
import com.spring.start.dto.factura.FacturaResponseDto;
import com.spring.start.entity.Factura;
import com.spring.start.mapper.FacturaMapper;
import com.spring.start.repository.FacturaRepository;
import com.spring.start.service.FacturaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	FacturaRepository facturaRepository;

	@Autowired
	FacturaMapper facturaMapper;

	private String errorMsg = "No se encuentra la factura solicitada, id: ";

	@Override
	public FacturaResponseDto findById(Long id) {
		Optional<Factura> facturaOptional = facturaRepository.findById(id);
		if (facturaOptional.isEmpty()) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}
		return facturaMapper.mapToFacturaResponseDto(facturaOptional.get());
	}

	@Override
	public List<FacturaResponseDto> findAll() {
		List<Factura> facturas = facturaRepository.findAll();
		return facturaMapper.mapToFacturaResponseDto(facturas);
	}

	@Override
	public FacturaResponseDto add(FacturaRequestDto dto) {
		facturaRepository.save(facturaMapper.mapFacturaRequestToFactura(dto));
		return facturaMapper.mapFacturaRequestToFacturaResponse(dto);
	}

	@Override
	public FacturaResponseDto update(Long id, FacturaRequestDto dto) {
		Optional<Factura> facturaOptional = facturaRepository.findById(id);
		if (facturaOptional.isEmpty()) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}
		Factura factura = facturaMapper.mapFacturaRequestToFactura(id, dto);
		facturaRepository.save(factura);
		return facturaMapper.mapToFacturaResponseDto(factura);
	}

	@Override
	public void delete(Long id) {
		if (!facturaRepository.existsById(id)) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}
		facturaRepository.deleteById(id);
	}
}
