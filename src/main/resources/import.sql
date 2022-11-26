INSERT INTO `docente` (`noIdentificacion`, `tipoIdentificacion`, `nombres`,`apellidos`,`universidad`,`tipoDocente`,`salario`) VALUES ('103424', 'Cedula', 'Laura','Gomez','Unicauca','Planta',1000000.0);
INSERT INTO `docente` (`noIdentificacion`, `tipoIdentificacion`, `nombres`,`apellidos`,`universidad`,`tipoDocente`,`salario`) VALUES ('5464', 'Cedula', 'Juan','Perez','Unicauca','Planta',1200000.0);

INSERT INTO `asignaturas` (`nombre`) VALUES ('Sistemas distribuidos');

INSERT INTO `cursos` (`idCurso`,`nombre`,`periodo`,`idAsignatura`) VALUES ('100',"Grupo A",2,1);

INSERT INTO `Docentes_Asignaturas` (`idDocente`,`idAsignatura`) VALUES (1,1);
INSERT INTO `Docentes_Asignaturas` (`idDocente`,`idAsignatura`) VALUES (2,1);