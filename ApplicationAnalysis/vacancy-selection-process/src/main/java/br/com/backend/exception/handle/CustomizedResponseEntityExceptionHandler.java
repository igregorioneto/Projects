package br.com.backend.exception.handle;

import br.com.backend.exception.ExceptionResponse;
import br.com.backend.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/*
 * Tratamento de exceções
 * @author Greg
 * @verion 1.0
 * @since 2023-12-12
 * */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /*
    * Exceção genérica
    * @param Exception mensagem de erro
    * @Param WebRequest para a requisição
    * @return ResponseEntity<ExceptionResponse> que é a classe criada para as exceções
    * */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(
            Exception ex, WebRequest request
    ) {
        ExceptionResponse exception =
                new ExceptionResponse(
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false)
                );
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /*
     * Exceção relacionada ao NOT FOUND
     * @param Exception mensagem de erro
     * @Param WebRequest para a requisição
     * @return ResponseEntity<ExceptionResponse> que é a classe criada para as exceções
     * */
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleResourceNotFoundException(
            Exception ex, WebRequest request
    ) {
        ExceptionResponse exception =
                new ExceptionResponse(
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false)
                );
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

}
