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
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.CodigoError;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.EntidadNoExisteException;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.EntidadYaExisteException;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.ErrorUtils;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.ReglaNegocioExcepcion;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.Error;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.ErrorAlmacenamientoDBException;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.NoContentException;

@ControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                    final Exception ex, final Locale locale) {
            final Error error = ErrorUtils
                            .crearError(CodigoError.ERROR_GENERICO.getCodigo(),
                                            CodigoError.ERROR_GENERICO.getLlaveMensaje(),
                                            HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(ErrorAlmacenamientoDBException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                    final ErrorAlmacenamientoDBException ex, final Locale locale) {
            final Error error = ErrorUtils
                            .crearError(CodigoError.VIOLACION_ALMACENAMIENTO_DB.getCodigo(),
                                            String.format("%s, %s", CodigoError.VIOLACION_ALMACENAMIENTO_DB.getLlaveMensaje(),
                                                            ex.getMessage()),
                                            HttpStatus.NOT_ACCEPTABLE.value())
                            .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
            return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }


    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                    final NoContentException ex, final Locale locale) {
            final Error error = ErrorUtils
                            .crearError(CodigoError.NO_CONTENT_LIST.getCodigo(),
                                            String.format("%s, %s", CodigoError.NO_CONTENT_LIST.getLlaveMensaje(),
                                                            ex.getMessage()),
                                            HttpStatus.NOT_FOUND.value())
                            .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(EntidadYaExisteException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                    final EntidadYaExisteException ex, final Locale locale) {
            final Error error = ErrorUtils
                            .crearError(CodigoError.ENTIDAD_YA_EXISTE.getCodigo(),
                                            String.format("%s, %s", CodigoError.ENTIDAD_YA_EXISTE.getLlaveMensaje(),
                                                            ex.getMessage()),
                                            HttpStatus.NOT_ACCEPTABLE.value())
                            .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
            return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ReglaNegocioExcepcion.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                    final ReglaNegocioExcepcion ex, final Locale locale) {
            final Error error = ErrorUtils
                            .crearError(CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getCodigo(), ex.formatException(),
                                            HttpStatus.BAD_REQUEST.value())
                            .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    


        @ExceptionHandler(EntidadNoExisteException.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final EntidadNoExisteException ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.ENTIDAD_NO_ENCONTRADA.getCodigo(),
                                                String.format("%s, %s",
                                                                CodigoError.ENTIDAD_NO_ENCONTRADA.getLlaveMensaje(),
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

