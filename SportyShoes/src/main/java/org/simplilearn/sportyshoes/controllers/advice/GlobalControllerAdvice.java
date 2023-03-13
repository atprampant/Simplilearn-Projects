package org.simplilearn.sportyshoes.controllers.advice;

import org.simplilearn.sportyshoes.exceptions.*;
import org.simplilearn.sportyshoes.utils.ResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    ResponseGenerator responseGenerator;


    @ExceptionHandler(value= {EmailNotFoundException.class,EmailAlreadyExistsException.class, UsernameNotFoundException.class,
            UsernameAlreadyExistsException.class, OrderNotFoundException.class})
    public ResponseEntity<String>generateExceptionResponse(BaseException baseException){
            return responseGenerator.generateResponse(baseException.getStatusCodes());
    }

}
