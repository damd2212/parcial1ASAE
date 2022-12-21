package co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions;

import lombok.Getter;

@Getter
public class ErrorAlmacenamientoDBException extends RuntimeException{
	
	private final String llaveMensaje;
	private final String codigo;
	
	public ErrorAlmacenamientoDBException(CodigoError code) {
		super(code.getCodigo());
		this.llaveMensaje = code.getLlaveMensaje();
		this.codigo = code.getCodigo();
	}
	
	public ErrorAlmacenamientoDBException(final String message) {
		super(message);
	    this.llaveMensaje = CodigoError.VIOLACION_ALMACENAMIENTO_DB.getLlaveMensaje();
	    this.codigo = CodigoError.VIOLACION_ALMACENAMIENTO_DB.getCodigo();
	}
}
