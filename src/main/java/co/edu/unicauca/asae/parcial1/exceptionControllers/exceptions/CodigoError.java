package co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CodigoError {

    ENTIDAD_NO_ENCONTRADA("GC-0008", "Recurso no encontrado");

    private final String codigo;
    private final String llaveMensaje;
}
