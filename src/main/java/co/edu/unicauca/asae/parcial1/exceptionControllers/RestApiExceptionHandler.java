package co.edu.unicauca.asae.parcial1.exceptionControllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.CodigoError;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.ErrorUtils;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.RecursoNoExisteException;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.Error;

@ControllerAdvice
public class RestApiExceptionHandler {
    
    @ExceptionHandler(RecursoNoExisteException.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final RecursoNoExisteException ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.RECURSO_NO_ENCONTRADO.getCodigo(),
                                                String.format("%s, %s",
                                                                CodigoError.RECURSO_NO_ENCONTRADO.getLlaveMensaje(),
                                                                ex.getMessage()),
                                                HttpStatus.NOT_FOUND.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
}
