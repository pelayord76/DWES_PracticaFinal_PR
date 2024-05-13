INSERT INTO usuario (nombre, email, contrasenia) VALUES('admin', 'admin@email.com', '$2a$12$YORr2teNaSVSof5LPbkCIuk5y4549Wp4ZYdW.NYqrJNFk2FWW.e5K');
INSERT INTO usuario (nombre, email, contrasenia) VALUES('raso', 'raso@email.com', '$2a$12$k5Ia/9oKC.WPvzfF8b73meex/bF5C5sda0h4CSkXBrcGGSWI9jAW.');


INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('Long island', 'dueño1', 000000000,'2024-12-31');
INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('B12', 'dueño2', 111111111,'2025-12-31');
INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('La Espuela', 'dueño3', 222222222,'2023-12-31');
INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('La Casuca', 'dueño4', 333333333,'2025-12-31');
INSERT INTO cliente (local, duenio, telefono, fecha_vencimiento_contrato) VALUES('Copas (sin maquina)', 'dueño4', 444444444,'2027-12-31');


INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, FK_CLIENTE) VALUES('Neopolis', '2024-12-31', 0, 1);
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, FK_CLIENTE) VALUES('Confidental', '2024-11-15', 0, 2);
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, FK_CLIENTE) VALUES('BFsM', '2024-12-31', 0, 2);	
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, FK_CLIENTE) VALUES('Flor de loto', '2024-10-01', 0, 3);
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, FK_CLIENTE) VALUES('Angels', '2024-09-30', 0, 4);


INSERT INTO tiene (usuario_id, maquina_id) VALUES(1, 1);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(1, 2);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(1, 3);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(1, 4);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(2, 1);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(2, 2);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(2, 3);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(2, 4);


INSERT INTO recaudacion (cantidad_recaudada, porcentaje_juego, fecha, FK_MAQUINA) VALUES(1000.0, 0.35, '2023-12-06', 1);
INSERT INTO recaudacion (cantidad_recaudada, porcentaje_juego, fecha, FK_MAQUINA) VALUES(1500.0, 0.77, '2023-12-06', 2);
INSERT INTO recaudacion (cantidad_recaudada, porcentaje_juego, fecha, FK_MAQUINA) VALUES(400.0, 0.33, '2023-12-06', 3);
INSERT INTO recaudacion (cantidad_recaudada, porcentaje_juego, fecha, FK_MAQUINA) VALUES(658.0, 0.45, '2023-12-06', 4);
INSERT INTO recaudacion (cantidad_recaudada, porcentaje_juego, fecha, FK_MAQUINA) VALUES(950.0, 0.50, '2023-12-06', 5);



INSERT INTO factura (iva, fecha_emision, FK_CLIENTE) VALUES (21, '2024-05-01', 1);
INSERT INTO factura (iva, fecha_emision, FK_CLIENTE) VALUES (21, '2024-06-01', 1);
INSERT INTO factura (iva, fecha_emision, FK_CLIENTE) VALUES (21, '2024-07-01', 1);
INSERT INTO factura (iva, fecha_emision, FK_CLIENTE) VALUES (21, '2024-06-01', 2);
INSERT INTO factura (iva, fecha_emision, FK_CLIENTE) VALUES (21, '2024-07-01', 2);
INSERT INTO factura (iva, fecha_emision, FK_CLIENTE) VALUES (21, '2024-08-01', 2);
INSERT INTO factura (iva, fecha_emision, FK_CLIENTE) VALUES (21, '2024-05-01', 3);
INSERT INTO factura (iva, fecha_emision, FK_CLIENTE) VALUES (21, '2024-06-01', 3);
INSERT INTO factura (iva, fecha_emision, FK_CLIENTE) VALUES (21, '2024-05-01', 4);
INSERT INTO factura (iva, fecha_emision, FK_CLIENTE) VALUES (21, '2024-06-01', 4);