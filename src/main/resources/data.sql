INSERT INTO usuario (nombre, email, contrasenia) VALUES('admin', 'admin@email.com', '$2a$12$YORr2teNaSVSof5LPbkCIuk5y4549Wp4ZYdW.NYqrJNFk2FWW.e5K');
INSERT INTO usuario (nombre, email, contrasenia) VALUES('raso', 'raso@email.com', '$2a$12$k5Ia/9oKC.WPvzfF8b73meex/bF5C5sda0h4CSkXBrcGGSWI9jAW.');


INSERT INTO cliente (local, duenio, telefono, direccion, cif, fecha_vencimiento_contrato) VALUES('bar1', 'dueño1', 000000000, 'direccion1', 'cif1', '2024-12-31');
INSERT INTO cliente (local, duenio, telefono, direccion, cif, fecha_vencimiento_contrato) VALUES('bar2', 'dueño2 (2 maquinas)', 111111111, 'direccion2', 'cif2', '2025-12-31');
INSERT INTO cliente (local, duenio, telefono, direccion, cif, fecha_vencimiento_contrato) VALUES('bar3', 'dueño3', 222222222, 'direccion3', 'cif3', '2023-12-31');
INSERT INTO cliente (local, duenio, telefono, direccion, cif, fecha_vencimiento_contrato) VALUES('bar4', 'dueño4', 333333333, 'direccion4', 'cif4', '2025-12-31');
INSERT INTO cliente (local, duenio, telefono, direccion, cif, fecha_vencimiento_contrato) VALUES('bar5 (sin maquina)', 'dueño5', 444444444, 'direccion5', 'cif5', '2027-12-31');


INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, tipo_maquina, FK_CLIENTE) VALUES('maquina1', '2024-12-31', 0, 1, 1);
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, tipo_maquina, FK_CLIENTE) VALUES('maquina2', '2024-11-15', 0, 0, 2);
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, tipo_maquina, FK_CLIENTE) VALUES('maquina3', '2024-12-31', 0, 1, 2);	
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, tipo_maquina, FK_CLIENTE) VALUES('maquina4', '2024-10-01', 0, 0, 3);
INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, tipo_maquina, FK_CLIENTE) VALUES('maquina5', '2024-09-30', 0, 1, 4);


INSERT INTO tiene (usuario_id, maquina_id) VALUES(1, 1);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(1, 2);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(1, 3);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(1, 4);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(2, 1);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(2, 2);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(2, 3);
INSERT INTO tiene (usuario_id, maquina_id) VALUES(2, 4);


INSERT INTO recaudacion (cantidad_recaudada, pasos_entrada, pasos_salida, porcentaje_juego, fecha, FK_MAQUINA) VALUES(1000.0, 4120, 3890, '2023-12-06', 1);
INSERT INTO recaudacion (cantidad_recaudada, pasos_entrada, pasos_salida, porcentaje_juego, fecha, FK_MAQUINA) VALUES(1500.0, 2500, 2300, '2023-12-06', 2);
INSERT INTO recaudacion (cantidad_recaudada, pasos_entrada, pasos_salida, porcentaje_juego, fecha, FK_MAQUINA) VALUES(400.0, 5130, 4900, '2023-12-06', 3);
INSERT INTO recaudacion (cantidad_recaudada, pasos_entrada, pasos_salida, porcentaje_juego, fecha, FK_MAQUINA) VALUES(658.0, 800, 670, '2023-12-06', 4);
INSERT INTO recaudacion (cantidad_recaudada, pasos_entrada, pasos_salida, porcentaje_juego, fecha, FK_MAQUINA) VALUES(950.0, 1900, 1350, '2023-12-06', 5);



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