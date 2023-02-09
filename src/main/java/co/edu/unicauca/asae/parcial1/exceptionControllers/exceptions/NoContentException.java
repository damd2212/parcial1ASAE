package co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions;

import lombok.Getter;

@Getter
public class NoContentException extends RuntimeException{
    private final String llaveMensaje;
	private final String codigo;

    public NoContentException(CodigoError code){
        super(code.getCodigo());
        this.llaveMensaje = code.getLlaveMensaje();
        this.codigo = code.getCodigo();
    }

    public NoContentException(final String message){
        super(message);
        this.llaveMensaje = CodigoError.NO_CONTENT_LIST.getLlaveMensaje();
        this.codigo = CodigoError.NO_CONTENT_LIST.getCodigo();
    }
    
}
