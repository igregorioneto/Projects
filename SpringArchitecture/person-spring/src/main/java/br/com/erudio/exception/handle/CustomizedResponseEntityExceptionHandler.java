package br.com.erudio.exception.handle;

import br.com.erudio.exception.ExceptionResponse;
import br.com.erudio.exception.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/*Tratamento de exceções
* @author Greg
* @version 1.0
* @since 2023-12-05
* */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /*
    * Criando uma exceção genérica
    * @param WebRequest para pegar a requisição
    * @param Exception para pegar a mensagem de erro
    * @Return ResponseEntity do tipo ExceptionResponse
    * */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(
            Exception ex, WebRequest request
    ) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false)
                );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
     * Criando uma exceção personalizada do Math
     * @param WebRequest para pegar a requisição
     * @param Exception para pegar a mensagem de erro
     * @Return ResponseEntity do tipo ExceptionResponse
     * */
    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(
            Exception ex, WebRequest request
    ) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
