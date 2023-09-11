package com.lliscano.springrestapi.advice;

import com.lliscano.springrestapi.dto.ResponseDTO;
import com.lliscano.springrestapi.exception.RecordNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Object> recordNotFoundExceptionHandler(final Exception exception) {
        log.error("RecordNotFoundException", exception);
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> genericExceptionHandler(final Exception exception) {
        log.error("GenericExceptionHandler", exception);
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .message("Internal server error")
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
