/*package com.spring.start.config;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.start.entity.Cliente;
import com.spring.start.entity.Maquina;
import com.spring.start.repository.ClienteRepository;
import com.spring.start.repository.MaquinaRepository;
import com.spring.start.service.MailService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Tareas {

	@Autowired
	private MaquinaRepository maquinaRepository;

	@Autowired
	private MailService mailService;

	@Autowired
	private ClienteRepository clienteRepository;

	@Scheduled(cron = "0 0 12 * * SUN")
	public void checkTiempoMaquinaAlmacenada() {
		List<Maquina> maquinas = maquinaRepository.findAll();
		for (Maquina m : maquinas) {
			if (m.isAlmacenada() && m.getFechaAlmacenada() != null) {
				long mesesAlmacenada = ChronoUnit.MONTHS.between(m.getFechaAlmacenada(), LocalDate.now());
				if (mesesAlmacenada >= 9) {
					log.info("Han pasado 9 meses desde que se almacenó la máquina con id: " + m.getId());
					// mandar correo al usuario
					mailService.avisoTiempoEnAlmacen(m);
				}
			}
		}
	}

	@Scheduled(cron = "0 0 12 * * SUN")
	public void checkFechaLicencia() {
		List<Maquina> maquinas = maquinaRepository.findAll();
		for (Maquina m : maquinas) {
			long mesesLicenciaRestantes = ChronoUnit.MONTHS.between(m.getFechaVencimientoLicencia(), LocalDate.now());
			if (mesesLicenciaRestantes < 3) {
				log.info("Quedan " + mesesLicenciaRestantes + "meses para que venza la licencia de la maquina con id: "
						+ m.getId());
				// mandar correo al usuario
				mailService.avisoLicencia(m);
			}
		}
	}

	@Scheduled(cron = "0 0 12 * * SUN")
	public void checkFechaContrato() {
		List<Cliente> clientes = clienteRepository.findAll();
		for (Cliente c : clientes) {
			long mesesContratoRestantes = ChronoUnit.MONTHS.between(c.getFechaVencimientoContrato(), LocalDate.now());
			if (mesesContratoRestantes < 3) {
				log.info("Quedan " + mesesContratoRestantes + "meses para que venza el contrato del cliente con id: "
						+ c.getId());
				// mandar correo al usuario
				mailService.avisoContrato(c);
			}
		}
	}
}*/