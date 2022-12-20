package co.edu.unicauca.asae.parcial1.exceptionControllers;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.RecursoNoExisteException;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.CodigoError;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.ErrorUtils;
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

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
                Map<String, String> errors = new HashMap<>();
                ex.getBindingResult().getAllErrors().forEach((error) -> {
                        String fieldName = ((FieldError) error).getField();
                        String errorMessage = error.getDefaultMessage();
                        errors.put(fieldName, errorMessage);
                });

                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(ConstraintViolationException.class)
        ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
                return new ResponseEntity<>("nombre del método y parametros erroneos: " + e.getMessage(),
                                HttpStatus.BAD_REQUEST);
        }

        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(NoSuchElementException.class)
        ResponseEntity<String> handleConstraintViolationException(NoSuchElementException e) {
                return new ResponseEntity<>("El elemento no existe en la  BD",
                                HttpStatus.NOT_FOUND);
        }
}