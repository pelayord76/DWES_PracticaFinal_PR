package com.spring.start.maquinas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.recaudaciones.Recaudacion;
import com.spring.start.recaudaciones.RecaudacionDAO;

@RestController
public class MaquinaController {

	@Autowired
	MaquinaDAO maquinaDAO;
	
	@Autowired
	RecaudacionDAO recaudacionDAO;

	
	
	@GetMapping("/maquina")
	public List<Maquina> getMaquinas() {
		return (List<Maquina>) maquinaDAO.findAll();
	}

	@GetMapping("/maquina/{id}")
	public Optional<Maquina> getMaquina(@PathVariable Long id) {
		return maquinaDAO.findById(id);
	}

	@GetMapping("/maquina/{id}/recaudacion")
	public List<Recaudacion> getRecaudaciones(@PathVariable Long id) {
		Maquina maquina = maquinaDAO.findById(id).get();
		return maquina.getRecaudaciones();
	}

	@DeleteMapping("/maquina/{id}")
	public ResponseEntity<Maquina> deleteMaquina(@PathVariable Long id) {
		Optional<Maquina> maquina = maquinaDAO.findById(id);

		if (maquina.isPresent()) {
			maquinaDAO.delete(maquina.get());
			return ResponseEntity.status(HttpStatus.FOUND).body(maquina.get());
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping("/maquina")
	public ResponseEntity<Maquina> postMaquina(@RequestBody Maquina maquina) {
		maquinaDAO.save(maquina);

		List<Recaudacion> recaudaciones = maquina.getRecaudaciones();
		for (Recaudacion r : recaudaciones) {

			recaudacionDAO.save(r);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(maquina);
	}

	/*
	 * @GetMapping("/maquina/betweenFechas") public List<Maquina>
	 * getMaquinasEntreFechasVencimientoLicencia(@RequestParam Date fecha1,
	 * 
	 * @RequestParam Date fecha2) { return
	 * maquinaDAO.findByFechaVencimientoLicenciaBetween(fecha1, fecha2); }
	 * 
	 * @GetMapping("/maquina/betweenIds") public List<Maquina>
	 * getMaquinasEntreIds(@RequestParam Long id1, @RequestParam Long id2) { return
	 * maquinaDAO.findByIdBetween(id1, id2); }
	 * 
	 * @GetMapping("/maquina/endingWithCadena") public List<Maquina>
	 * getMaquinasEndingWith(@RequestParam String cadena) { return
	 * maquinaDAO.findByNombreEndingWith(cadena); }
	 * 
	 * @GetMapping("/maquina/betweenId/orderByNombre") public List<Maquina>
	 * getMaquinasEntreIdsOrdenAlfabetico(@RequestParam Long id1, @RequestParam Long
	 * id2) { return maquinaDAO.findByIdBetweenOrderByNombreAsc(id1, id2); }
	 * 
	 * @GetMapping("/maquina/idNotIn") public List<Maquina>
	 * getMaquinasExcluyendoIds(@RequestParam List<Long> idsExcluidos) { return
	 * maquinaDAO.findByIdNotIn(idsExcluidos); }
	 * 
	 * @GetMapping("/maquina/byNombre") public List<Maquina>
	 * getMaquinasPorNombre(@RequestParam("nombre") String nombre) { return
	 * maquinaDAO.findByNombreIgnoreCase(nombre); }
	 */
}
