package co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CodigoError {


        ERROR_GENERICO("GC-0001", "ERROR GENERICO"),
        ENTIDAD_YA_EXISTE("GC-0002", "ERROR ENTIDAD YA EXISTE"),
        ENTIDAD_NO_ENCONTRADA("GC-0008", "Recurso no encontrado"),
        VIOLACION_REGLA_DE_NEGOCIO("GC-0004", "Regla de negocio violada");
        
        private final String codigo;
        private final String llaveMensaje;

}
