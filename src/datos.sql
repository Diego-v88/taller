Insert Into DAY (id,name) VALUES 
(1, 'Lunes'),
(2,'Martes'),
(3,'Miercoles'),
(4,'Jueves'),
(5,'Viernes'),
(6,'Sabado'),
(7,'Domingo');

INSERT INTO GUARDNOTIFICATIONTYPE (id,description) VALUES 
(1,'Telefono'),
(2,'E-Mail'),
(3,'Calendario');

INSERT INTO TURNTYPE (id,name,timespan) Values 
(1,'Madrugada', '00:00 a 04:00'),
(2,'Mañana', '04:00 a 08:00'),
(3,'Medio dia', '08:00 a 12:00'),
(4,'Siesta', '12:00 a 16:00'),
(5,'tarde', '16:00 a 20:00'),
(6,'Noche', '20:00 a 23:59');