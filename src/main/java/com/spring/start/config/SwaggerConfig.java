package com.spring.start.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

/**
 * clase de configuracion del swagger
 * 
 * 
 * @author pelayord
 */

@Configuration
public class SwaggerConfig {

	@Value("${swaggerurl-dev}")
	private String urldev;

	@Bean
	OpenAPI config() {
		Contact contact = new Contact();
		contact.setEmail("pelayord76@educastur.es");
		contact.setName("Pelayo Rodríguez Díaz");
		contact.setUrl("https://linktr.ee/pelayord");

		License mitLicense = new License().name("MIT License").url("https://opensource.org/licenses/MIT");

		Info info = new Info().title("Documentacion API REST").version("1.0").contact(contact).description(
				"Esta API REST proporciona funcionalidades para gestionar la base de datos de negocios de máquinas recreativas.")
				.license(mitLicense);

		Server devServer = new Server();
		devServer.setUrl(urldev);
		devServer.setDescription("Server URL in Development environment");

		Server prodServer = new Server();
		prodServer.setUrl("prodUrl");
		prodServer.setDescription("Server URL in Production environment");

		return new OpenAPI().info(info).servers(List.of(devServer, prodServer));

	}

}