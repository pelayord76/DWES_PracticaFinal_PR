INSERT INTO usuario (nombre, email, contrasenia, tipo_usuario) VALUES('Usuario1', 'usuario1@email.com', 'usuario1', 0);
INSERT INTO usuario (nombre, email, contrasenia, tipo_usuario) VALUES('Usuario2', 'usuario2@email.com', 'usuario2', 0);
INSERT INTO usuario (nombre, email, contrasenia, tipo_usuario) VALUES('Usuario3', 'usuario3@email.com', 'usuario3', 0);

INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('Long island', 'dueño1', 000000000,'2024-12-31');
INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('Bar2', 'dueño2', 111111111,'2025-12-31');
INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('Bar3', 'dueño3', 222222222,'2023-12-31');
INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('Bar4', 'dueño4', 333333333,'2025-12-31');

INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, FK_CLIENTE) VALUES('Neopolis', '2024-12-31', 0, 1);
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, FK_CLIENTE) VALUES('Confidental', '2024-11-15', 0, 2);
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, FK_CLIENTE) VALUES('BFsM', '202-12-31', 0, 2);	
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, FK_CLIENTE) VALUES('Flor de loto', '2024-10-01', 0, 3);
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, FK_CLIENTE) VALUES('Angels', '2024-09-30', 0, 4);

INSERT INTO tiene (usuario_id, maquina_id) VALUES(1, 1);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(1, 2);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(2, 1);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(2, 2);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(3, 3);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(3, 4);

INSERT INTO recaudacion (cantidad_recaudada, porcentaje_juego, fecha, FK_MAQUINA) VALUES(1000.0, 0.35, '2023-12-06', 1);
INSERT INTO recaudacion (cantidad_recaudada, porcentaje_juego, fecha, FK_MAQUINA) VALUES(1500.0, 0.77, '2023-12-06', 2);
INSERT INTO recaudacion (cantidad_recaudada, porcentaje_juego, fecha, FK_MAQUINA) VALUES(800.0, 0.63, '2023-12-06', 3);