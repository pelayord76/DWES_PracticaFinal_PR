package com.spring.start.clientes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.maquinas.Maquina;
import com.spring.start.maquinas.MaquinaDAO;

@RestController
public class ClienteController {

	@Autowired
	ClienteDAO clienteDAO;
	
	@Autowired
	MaquinaDAO maquinaDAO;
	
	
	
	@GetMapping("/cliente")
	public List<Cliente> getClientes() {
		return (List<Cliente>) clienteDAO.findAll();
	}

	@GetMapping("/cliente/{id}")
	public Optional<Cliente> getCLiente(@PathVariable Long id) {
		return clienteDAO.findById(id);
	}

	@GetMapping("/cliente/{id}/maquina")
	public List<Maquina> getMaquinas(@PathVariable Long id) {
		Cliente cliente = clienteDAO.findById(id).get();
		return cliente.getMaquinas();
	}

	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteDAO.findById(id);

		if (cliente.isPresent()) {
			clienteDAO.delete(cliente.get());
			return ResponseEntity.status(HttpStatus.FOUND).body(cliente.get());
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
//	@PostMapping("/maquina")
//	public ResponseEntity<Maquina> postMaquina(@RequestBody Maquina maquina) {
//		maquinaDAO.save(maquina);
//
//		List<Recaudacion> recaudaciones = maquina.getRecaudaciones();
//		for (Recaudacion r : recaudaciones) {
//
//			recaudacionDAO.save(r);
//		}
//
//		return ResponseEntity.status(HttpStatus.CREATED).body(maquina);
//	}
}
