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

@Service
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

		Optional<Usuario> usuarioOptional = usuarioRepository.findById(key.getIdUsuario());
		Optional<Maquina> maquinaOptional = maquinaRepository.findById(key.getIdMaquina());

		if (usuarioOptional.isEmpty() || maquinaOptional.isEmpty()) {
			throw new IllegalArgumentException("El usuario y la maquina deben existir");
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
		key.setIdUsuario(idUsuario);
		key.setIdMaquina(idMaquina);
		if (tieneRepository.findById(key).isEmpty()) {
			throw new IllegalArgumentException("No existe ninguna relación con esos campos");
		}
		tieneRepository.deleteById(key);
	}
}
