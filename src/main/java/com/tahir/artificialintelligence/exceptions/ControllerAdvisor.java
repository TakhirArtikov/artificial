package com.tahir.artificialintelligence.exceptions;

import com.tahir.artificialintelligence.models.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNodataFoundException(
            NotFoundException ex) {
        ResponseData responseData = new ResponseData();
        responseData.setResponse(null);
        responseData.setStatus(HttpStatus.NOT_FOUND);
        responseData.setTimestamp(LocalDateTime.now());
        responseData.setError(ex.getLocalizedMessage());
        return new ResponseEntity<>(responseData,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> runtimeException(
            Exception ex) {
        ResponseData responseData = new ResponseData();
        responseData.setResponse(null);
        responseData.setStatus(HttpStatus.BAD_GATEWAY);
        responseData.setTimestamp(LocalDateTime.now());
        responseData.setError(ex.getLocalizedMessage());
        return new ResponseEntity<>(responseData,HttpStatus.BAD_GATEWAY);
    }
}