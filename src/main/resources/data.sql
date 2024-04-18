INSERT INTO usuario (nombre, email, contrasenia) VALUES('admin', 'admin@email.com', '$2a$12$YORr2teNaSVSof5LPbkCIuk5y4549Wp4ZYdW.NYqrJNFk2FWW.e5K');
INSERT INTO usuario (nombre, email, contrasenia) VALUES('raso', 'usuario2@email.com', '$2a$12$k5Ia/9oKC.WPvzfF8b73meex/bF5C5sda0h4CSkXBrcGGSWI9jAW.');
INSERT INTO usuario (nombre, email, contrasenia) VALUES('pepe', 'pepe@email.com', '$2a$12$E9AI9DOVpvhbAT5rWLAnUuJ4vnzpM3r4boiTOu2Nfxwq9orpWi1Pe');
INSERT INTO usuario (nombre, email, contrasenia) VALUES('pelayo', 'pelayo@email.com', '$2a$12$aI38mqhCOlBbZQqNzs8pMu1DgONm4M.McTvHfr3LFuJTE//52SJAS');

INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('Long island', 'dueño1', 000000000,'2024-12-31');
INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('Bar2', 'dueño2', 111111111,'2025-12-31');
INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('Bar3', 'dueño3', 222222222,'2023-12-31');
INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('Bar4', 'dueño4', 333333333,'2025-12-31');
INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('bar sin maquina', 'dueño4', 444444444,'2027-12-31');


INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, FK_CLIENTE) VALUES('Neopolis', '2024-12-31', 0, 1);
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, FK_CLIENTE) VALUES('Confidental', '2024-11-15', 0, 2);
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, FK_CLIENTE) VALUES('BFsM', '2024-12-31', 0, 2);	
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