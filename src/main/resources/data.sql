INSERT INTO usuario (nombre, email, contrasenia) VALUES 
('admin', 'admin@email.com', '$2a$12$YORr2teNaSVSof5LPbkCIuk5y4549Wp4ZYdW.NYqrJNFk2FWW.e5K'),
('raso', 'raso@email.com', '$2a$12$k5Ia/9oKC.WPvzfF8b73meex/bF5C5sda0h4CSkXBrcGGSWI9jAW.');


INSERT INTO cliente (local, duenio, telefono, direccion, cif, fecha_vencimiento_contrato) VALUES 
('bar1', 'dueño1', 000000000, 'direccion1', 'cif1', '2024-12-31'),
('bar2', 'dueño2', 111111111, 'direccion2', 'cif2', '2025-12-31'),
('bar3', 'dueño3', 222222222, 'direccion3', 'cif3', '2023-12-31'),
('bar4', 'dueño4', 333333333, 'direccion4', 'cif4', '2025-12-31'),
('bar5', 'dueño5', 444444444, 'direccion5', 'cif5', '2027-12-31'),
('bar6', 'dueño6', 555555555, 'direccion6', 'cif6', '2026-12-31'),
('bar7', 'dueño7', 666666666, 'direccion7', 'cif7', '2025-12-31'),
('bar8', 'dueño8', 777777777, 'direccion8', 'cif8', '2026-12-31'),
('bar9', 'dueño9', 888888888, 'direccion9', 'cif9', '2024-12-31'),
('bar10', 'dueño10', 999999999, 'direccion10', 'cif10', '2027-12-31');


INSERT INTO maquina (nombre, fecha_vencimiento_licencia, almacenada, fecha_almacenamiento, tipo_maquina, FK_CLIENTE) VALUES 
('maquina1', '2024-12-31', 0, null, 'BILLETES', 1),
('maquina2', '2024-11-15', 0, null, 'MONEDAS', 2),
('maquina3', '2024-12-31', 0, null, 'BILLETES', 2),
('maquina4', '2024-10-01', 0, null, 'MONEDAS', 3),
('maquina5', '2024-09-30', 0, null, 'BILLETES', 4),
('maquina6', '2025-12-31', 0, null, 'BILLETES', 6),
('maquina7', '2025-11-15', 0, null, 'MONEDAS', 7),
('maquina8', '2025-12-31', 0, null, 'BILLETES', 7),
('maquina9', '2025-10-01', 0, null, 'MONEDAS', 8),
('maquina10', '2025-09-30', 0, null, 'BILLETES', 9);


INSERT INTO tiene (usuario_id, maquina_id) VALUES
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8), (1, 9), (1, 10),
(2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6), (2, 7), (2, 8), (2, 9), (2, 10);


INSERT INTO recaudacion (cantidad_recaudada, pasos_entrada, pasos_salida, porcentaje_juego, tasa_recaudacion, fecha, FK_MAQUINA) VALUES 
(1000.0, 4120, 3890, 60.0, 200, '2023-12-06', 1),
(1500.0, 2500, 2300, 60.0, 200, '2023-12-06', 2),
(400.0, 5130, 4900, 60.0, 200, '2023-12-06', 3),
(658.0, 800, 670, 60.0, 200, '2023-12-06', 4),
(300.0, 400, 250, 45.0, 50, '2023-12-14', 4),
(950.0, 1900, 1350, 60.0, 200, '2023-12-06', 5),
(1100.0, 4300, 4000, 60.0, 210, '2023-12-07', 6),
(1200.0, 2600, 2400, 60.0, 220, '2023-12-07', 7),
(500.0, 5200, 5000, 60.0, 230, '2023-12-07', 8),
(700.0, 900, 800, 60.0, 240, '2023-12-07', 9),
(400.0, 500, 300, 45.0, 100, '2023-12-15', 10),
(960.0, 2000, 1400, 60.0, 250, '2023-12-07', 6);


INSERT INTO factura (iva, fecha_emision, FK_CLIENTE) VALUES 
(21, '2024-05-01', 1), (21, '2024-06-01', 1), (21, '2024-07-01', 1),
(21, '2024-06-01', 2), (21, '2024-07-01', 2), (21, '2024-08-01', 2),
(21, '2024-05-01', 3), (21, '2024-06-01', 3),
(21, '2024-05-01', 4), (21, '2024-06-01', 4),
(21, '2024-09-01', 6), (21, '2024-10-01', 6), (21, '2024-11-01', 6),
(21, '2024-12-01', 7), (21, '2025-01-01', 7), (21, '2025-02-01', 7),
(21, '2024-09-01', 8), (21, '2024-10-01', 8),
(21, '2024-11-01', 9), (21, '2024-12-01', 9);
