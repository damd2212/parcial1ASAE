package co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions;

import lombok.Getter;

@Getter
public class RecursoNoExisteException extends RuntimeException {
    private final String llaveMensaje;
    private final String codigo;

    public RecursoNoExisteException(CodigoError code) {
        super(code.getCodigo());
        this.llaveMensaje = code.getLlaveMensaje();
        this.codigo = code.getCodigo();
    }

    public RecursoNoExisteException(final String message) {
        super(message);
        this.llaveMensaje = CodigoError.RECURSO_NO_ENCONTRADO.getLlaveMensaje();
        this.codigo = CodigoError.RECURSO_NO_ENCONTRADO.getCodigo();
    }
}
