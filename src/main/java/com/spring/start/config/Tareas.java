package com.spring.start.config;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.start.entity.Maquina;
import com.spring.start.repository.MaquinaRepository;

@Component
public class Tareas {

	private static final Logger logger = LoggerFactory.getLogger(Tareas.class);

	@Autowired
	private MaquinaRepository maquinaRepository;

	@Scheduled(cron = "0 0 0 1 * ?")
	public void checkTiempoMaquinaAlmacenada() {
		List<Maquina> maquinas = maquinaRepository.findAll();
		for (Maquina m : maquinas) {
			if (m.getAlmacenada() && m.getFechaAlmacenada() != null) {
				long mesesAlmacenada = ChronoUnit.MONTHS.between(m.getFechaAlmacenada(), LocalDate.now());
				if (mesesAlmacenada >= 9) {
					notificar(m);
				}
			}
		}
	}

	private void notificar(Maquina maquina) {
		logger.info("Han pasado 9 meses desde que se almacenó la máquina con id: " + maquina.getId());
	}
}
