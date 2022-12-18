INSERT INTO `docente` (`noIdentificacion`, `tipoIdentificacion`, `nombres`,`apellidos`,`universidad`,`tipoDocente`,`salario`) VALUES ('103424', 'Cedula', 'Laura','Gomez','Unicauca','Planta',1000000.0);
INSERT INTO `docente` (`noIdentificacion`, `tipoIdentificacion`, `nombres`,`apellidos`,`universidad`,`tipoDocente`,`salario`) VALUES ('5464', 'Cedula', 'Juan','Perez','Unicauca','Planta',1200000.0);

INSERT INTO `asignaturas` (`nombre`) VALUES ('Sistemas distribuidos');

INSERT INTO `cursos` (`idCurso`,`nombre`,`periodo`,`idAsignatura`) VALUES ('100',"Grupo A",2,1);
INSERT INTO `cursos` (`idCurso`,`nombre`,`periodo`,`idAsignatura`) VALUES ('101',"Grupo B",2,1);
INSERT INTO `cursos` (`idCurso`,`nombre`,`periodo`,`idAsignatura`) VALUES ('103',"Grupo C",2,1);

INSERT INTO `Docentes_Asignaturas` (`idDocente`,`idAsignatura`) VALUES (1,1);
INSERT INTO `Docentes_Asignaturas` (`idDocente`,`idAsignatura`) VALUES (2,1);


INSERT INTO estudiante (NOIDENTIFICACION, TIPOIDENTIFICACION, NOMBRES,APELLIDOS,FECHAINGRESO,CORREOELECTRONICO) VALUES ('10611','Cedula','Danny','Diaz','2017-07-22','danny@unicauca.edu.co')
INSERT INTO estudiante (NOIDENTIFICACION, TIPOIDENTIFICACION, NOMBRES,APELLIDOS,FECHAINGRESO,CORREOELECTRONICO) VALUES ('10612','Cedula','Jhon','Zuniga','2017-08-25','jhon@unicauca.edu.co')

INSERT INTO direcciones (IDESTUDIANTE, CIUDAD, DIRECCIONRESIDENCIA,PAIS) VALUES (1,'Popayan','Calle 5C # 57A-58','Colombia')
INSERT INTO direcciones (IDESTUDIANTE, CIUDAD, DIRECCIONRESIDENCIA,PAIS) VALUES (2,'Popayan','Cra 78 # 2- 26','Colombia')

INSERT INTO telefonos (IDESTUDIANTE, NUMERO, TIPO) VALUES (1,'8345622','Fijo')
INSERT INTO telefonos (IDESTUDIANTE, NUMERO, TIPO) VALUES (1,'3216547789','Movil')
INSERT INTO telefonos (IDESTUDIANTE, NUMERO, TIPO) VALUES (2,'8364588','Fijo')
INSERT INTO telefonos (IDESTUDIANTE, NUMERO, TIPO) VALUES (2,'3006594558','Movil')
