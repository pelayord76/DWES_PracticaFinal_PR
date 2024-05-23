package com.spring.start.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.ClienteDataIngresosDTO;
import com.spring.start.entity.Cliente;
import com.spring.start.entity.Maquina;
import com.spring.start.entity.Recaudacion;
import com.spring.start.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteDAO;

	@GetMapping
	public List<Cliente> getClientes() {
		return (List<Cliente>) clienteDAO.findAll();
	}

	@GetMapping("/{id}")
	public Cliente getCLiente(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteDAO.findById(id);
		if (cliente.isPresent()) {
			return cliente.get();
		}
		return null;
	}

	@PostMapping
	public void addCliente(@RequestBody Cliente cliente) {
		clienteDAO.save(cliente);
	}

	@PutMapping("/{id}")
	public void editCliente(@PathVariable long id, @RequestBody Cliente cliente) {
		Optional<Cliente> oldCliente = clienteDAO.findById(id);
		if (oldCliente.isPresent()) {
			Cliente newCliente = oldCliente.get();
			newCliente.setDuenio(cliente.getDuenio());
			newCliente.setFechaVencimientoContrato(cliente.getFechaVencimientoContrato());
			newCliente.setLocal(cliente.getLocal());
			newCliente.setMaquinas(cliente.getMaquinas());
			newCliente.setTelefono(cliente.getTelefono());
			clienteDAO.save(newCliente);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Long id) {
		clienteDAO.deleteById(id);
	}

	@GetMapping("/data/ingresos")
	public List<ClienteDataIngresosDTO> getDatosDeIngresosPorClientes() {
		List<ClienteDataIngresosDTO> data = new ArrayList<>();
		List<Cliente> clientes = (List<Cliente>) clienteDAO.findAll();

		for (int i = 0; i < clientes.size(); i++) {
			ClienteDataIngresosDTO dto = new ClienteDataIngresosDTO();
			dto.setLocal(clientes.get(i).getLocal());
			List<Maquina> maquinas = clientes.get(i).getMaquinas();
			List<Recaudacion> recaudaciones = new ArrayList<>();

			for (int j = 0; j < maquinas.size(); j++) {
				recaudaciones.addAll(maquinas.get(j).getRecaudaciones());
				double total = 0;

				for (int k = 0; k < recaudaciones.size(); k++) {
					total += recaudaciones.get(k).getCantidadRecaudada();
				}
				dto.setCantidadRecaudada(total);
			}
			data.add(dto);
		}
		return data;
	}
}
