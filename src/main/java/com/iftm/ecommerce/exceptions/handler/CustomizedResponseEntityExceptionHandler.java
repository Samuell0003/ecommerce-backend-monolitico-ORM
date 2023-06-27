package com.iftm.ecommerce.exceptions.handler;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.iftm.ecommerce.exceptions.ExceptionResponse;
import com.iftm.ecommerce.exceptions.RequeridObjectIsNullException;
import com.iftm.ecommerce.exceptions.RequiredFieldNotInformed;
import com.iftm.ecommerce.exceptions.ResourceNotFoundException;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    // Exceção Genérica
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handlerAllExceptions(Exception ex, WebRequest request) {
        var exceptionResponse = new ExceptionResponse(
                new Date(), 
                ex.getMessage(), 
                request.getDescription(false)
            );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    // Exceção Customizada
    @ExceptionHandler(RequeridObjectIsNullException.class)
    public final ResponseEntity<ExceptionResponse> handlerRequiridObjectIsNullException(Exception ex, WebRequest request) {
        var exceptionResponse = new ExceptionResponse(
                new Date(), 
                ex.getMessage(), 
                request.getDescription(false)
            );
    
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handlerResourceNotFoundException(Exception ex, WebRequest request) {
        var exceptionResponse = new ExceptionResponse(
                new Date(), 
                ex.getMessage(), 
                request.getDescription(false)
            );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(RequiredFieldNotInformed.class)
    public final ResponseEntity<ExceptionResponse> handlerRequiredFieldNotInformed(Exception ex, WebRequest request) {
        var exceptionResponse = new ExceptionResponse(
                new Date(), 
                ex.getMessage(), 
                request.getDescription(false)
            );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
