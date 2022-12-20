package co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CodigoError {

    RECURSO_NO_ENCONTRADO("GC-0008", "Recurso no encontrado");

    private final String codigo;
    private final String llaveMensaje;
}
