package com.spring.start.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.start.entity.Maquina;
import com.spring.start.entity.Tiene;
import com.spring.start.entity.TieneKey;
import com.spring.start.entity.Usuario;
import com.spring.start.repository.MaquinaRepository;
import com.spring.start.repository.TieneRepository;
import com.spring.start.repository.UsuarioRepository;
import com.spring.start.service.TieneService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TieneServiceImpl implements TieneService {

	@Autowired
	private TieneRepository tieneRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private MaquinaRepository maquinaRepository;

	@Override
	public List<Tiene> findAll() {
		return tieneRepository.findAll();
	}

	@Override
	public Tiene add(TieneKey key) {

		Optional<Usuario> usuarioOptional = usuarioRepository.findById(key.getUsuarioId());
		Optional<Maquina> maquinaOptional = maquinaRepository.findById(key.getMaquinaId());

		if (usuarioOptional.isEmpty() || maquinaOptional.isEmpty()) {
			log.error("El usuario o la maquina no existen");
			throw new IllegalArgumentException("El usuario o la maquina no existen");
		}

		Tiene tieneAdd = new Tiene();
		tieneAdd.setId(key);
		tieneAdd.setUsuario(usuarioOptional.get());
		tieneAdd.setMaquina(maquinaOptional.get());

		return tieneRepository.save(tieneAdd);
	}

	@Override
	public void delete(long idUsuario, long idMaquina) {
		TieneKey key = new TieneKey();
		key.setUsuarioId(idUsuario);
		key.setMaquinaId(idMaquina);
		if (tieneRepository.existsById(key)) {
			throw new IllegalArgumentException("No existe una relacion entre esas entidades: usuario[" + idUsuario
					+ "], maquina[" + idMaquina + "]");
		}
		tieneRepository.deleteById(key);
	}

	@Override
	public List<Tiene> findByUsuarioId(long idUsuario) {
		if (!usuarioRepository.existsById(idUsuario)) {
			log.error("No se encuentra el usuario solicitado, id: " + idUsuario);
			throw new IllegalArgumentException("No se encuentra el usuario solicitado, id: " + idUsuario);
		}
		return tieneRepository.findByUsuarioId(idUsuario);
	}

	@Override
	public List<Tiene> findByMaquinaId(long idMaquina) {
		if (!maquinaRepository.existsById(idMaquina)) {
			log.error("No se encuentra la maquina solicitada, id: " + idMaquina);
			throw new IllegalArgumentException("No se encuentra la maquina solicitada, id: " + idMaquina);
		}
		return tieneRepository.findByMaquinaId(idMaquina);
	}
}
