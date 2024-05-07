package com.spring.start.facturas;

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
public class FacturaController {

	@Autowired
	FacturaDAO facturaDAO;

	@GetMapping("/factura")
	public List<Factura> getFacturas() {
		return (List<Factura>) facturaDAO.findAll();
	}

	@GetMapping("/factura/{id}")
	public Factura getFactura(@PathVariable long id) {
		Optional<Factura> factura = facturaDAO.findById(id);
		if (factura.isPresent()) {
			return factura.get();
		}
		return null;
	}

	@PostMapping("/factura/add")
	public void addFactura(@RequestBody Factura factura) {
		facturaDAO.save(factura);
	}

	@PutMapping("/factura/edit/{id}")
	public void editFactura(@PathVariable long id, @RequestBody Factura newFactura) {
		Optional<Factura> oldFactura = facturaDAO.findById(id);
		if (oldFactura.isPresent()) {
			Factura factura = oldFactura.get();
			factura.setIva(newFactura.getIva());
			factura.setFechaEmision(newFactura.getFechaEmision());
			factura.setCliente(newFactura.getCliente());
			facturaDAO.save(factura);
		}
	}
	
	@DeleteMapping("/factura/del/{id}")
	public void deleteFactura(@PathVariable long id){
		facturaDAO.deleteById(id);
	}
}