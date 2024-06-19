package com.spring.start.service;

/**
 * @author pelayord
 */
public interface MailService {

	/**
	 * metodo para mandar un correo al usuario cuando quede poco (menos de 3 meses)
	 * para que la maquina cumpla 1 año en almacen
	 * 
	 * @param m
	 
	void avisoTiempoEnAlmacen(Maquina m);*/

	/**
	 * metodo para mandar un correo al usuario cuando la licencia de la maquina este
	 * cerca de vencerse
	 * 
	 * @param m
	 
	void avisoLicencia(Maquina m);*/

	/**
	 * metodo para mandar un correo recordatorio al usuario cuando quede poco para
	 * que se acabe el contrato con un cliente
	 * 
	 * @param c
	 
	void avisoContrato(Cliente c);*/
}
