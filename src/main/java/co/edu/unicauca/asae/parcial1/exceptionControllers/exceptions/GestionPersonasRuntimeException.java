package co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GestionPersonasRuntimeException extends RuntimeException {

  protected CodigoError codigoError;

  public abstract String formatException();
}
