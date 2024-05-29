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

@Service
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	FacturaRepository facturaRepository;

	@Autowired
	FacturaMapper facturaMapper;

	@Override
	public FacturaResponseDto findById(Long id) {
		Optional<Factura> facturaOptional = facturaRepository.findById(id);
		if (facturaOptional.isEmpty()) {
			throw new IllegalArgumentException("No existe esa factura");
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
			throw new IllegalArgumentException("No existe esa factura");
		}
		Factura factura = facturaMapper.mapFacturaRequestToFactura(id, dto);
		facturaRepository.save(factura);
		return facturaMapper.mapToFacturaResponseDto(factura);
	}

	@Override
	public void delete(Long id) {
		if (!facturaRepository.existsById(id)){
			throw new IllegalArgumentException("No existe esa factura");
		}
		facturaRepository.deleteById(id);
	}
}
