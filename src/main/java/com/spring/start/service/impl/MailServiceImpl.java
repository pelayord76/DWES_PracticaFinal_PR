/*package com.spring.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.spring.start.entity.Cliente;
import com.spring.start.entity.Maquina;
import com.spring.start.service.MailService;

public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender emailSender;

	private String correoOrigen = "pelayorodriguezdiaz@gmail.com";

	@Override
	public void avisoTiempoEnAlmacen(Maquina m) {
		SimpleMailMessage message = new SimpleMailMessage();

		String destinatario = "";
//		Usuario usuario = m.getUsuario().getEmail();

		String asunto = "Tiempo de almacenamiento || Máquina " + m.getId();

		String mensaje = "La máquina " + m.getNombre() + " con id " + m.getId() + " que fue almacenada el día "
				+ m.getFechaAlmacenada() + " está cerca de cumplir un año en almacén.";

		message.setFrom(correoOrigen);
		message.setTo(destinatario);
		message.setSubject(asunto);
		message.setText(mensaje);

		emailSender.send(message);
	}

	@Override
	public void avisoLicencia(Maquina m) {
		SimpleMailMessage message = new SimpleMailMessage();

		String destinatario = "";
//		Usuario usuario = m.getUsuario().getEmail();

		String asunto = "Fin de licencia || Máquina " + m.getId();

		String mensaje = "La licencia de la máquina " + m.getNombre() + " con id " + m.getId()
				+ " está cerca de acabarse.\nFecha de vencimiento: " + m.getFechaVencimientoLicencia() + ".";

		message.setFrom(correoOrigen);
		message.setTo(destinatario);
		message.setSubject(asunto);
		message.setText(mensaje);

		emailSender.send(message);

	}

	@Override
	public void avisoContrato(Cliente c) {
		SimpleMailMessage message = new SimpleMailMessage();

		String destinatario = "";
//		Usuario usuario = m.getUsuario().getEmail();

		String asunto = "Fin de contrato || Cliente " + c.getId();

		String mensaje = "El contrato con el cliente " + c.getDuenio() + ".\nDueño del local " + c.getLocal() + ", "
				+ c.getDireccion() + ".\nCon CIF " + c.getCif() + "\nEstá cerca de acabarse: "
				+ c.getFechaVencimientoContrato() + ".";

		message.setFrom(correoOrigen);
		message.setTo(destinatario);
		message.setSubject(asunto);
		message.setText(mensaje);

		emailSender.send(message);

	}
}
*/