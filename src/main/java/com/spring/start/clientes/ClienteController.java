package com.spring.start.clientes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	@Autowired
	ClienteDAO clienteDAO;

	@GetMapping("/cliente")
	public List<Cliente> getClientes() {
		return (List<Cliente>) clienteDAO.findAll();
	}

	@GetMapping("/cliente/{id}")
	public Cliente getCLiente(@PathVariable Long id) {
		return clienteDAO.findById(id).get();
	}
	
	@PostMapping("/cliente/add")
	public void addCliente(@RequestBody Cliente cliente) {
		clienteDAO.save(cliente);
	}
	
	@PutMapping("/cliente/edit/{id}")
	public void editCliente(@PathVariable long id, @RequestBody Cliente cliente) {
		Optional<Cliente> oldCliente = clienteDAO.findById(id);
		if(oldCliente.isPresent()){
			Cliente newCliente = oldCliente.get();
			newCliente.setDuenio(cliente.getDuenio());
			newCliente.setFechaVencimientoContrato(cliente.getFechaVencimientoContrato());
			newCliente.setLocal(cliente.getLocal());
			newCliente.setMaquinas(cliente.getMaquinas());
			newCliente.setTelefono(cliente.getTelefono());
			clienteDAO.save(newCliente);
		}
	}
	
	@DeleteMapping("/cliente/del/{id}")
	public void deleteCliente(@PathVariable Long id) {
		clienteDAO.deleteById(id);
	}
}