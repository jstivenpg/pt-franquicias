package com.nequi.franchises.shared.application.exceptions;

import com.nequi.franchises.shared.application.dtos.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseDTO handleMissingServletRequestParameterException(
            MissingServletRequestParameterException ex) {
        log.error("Parameter: {} Details: {}", ex.getParameterName(), ex.getMessage());
        return new ErrorResponseDTO(ResponseCode.BAD_REQUEST.name(),
                ResponseCode.BAD_REQUEST.getMessage(),
                ResponseCode.BAD_REQUEST.getHttpStatus(),
                List.of(new FieldCustomError(ex.getParameterName(), ex.getMessage())));
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseDTO handleMissingServletRequestPartException(
            MissingServletRequestPartException ex) {
        return new ErrorResponseDTO(ResponseCode.BAD_REQUEST.name(),
                ResponseCode.BAD_REQUEST.getMessage(),
                ResponseCode.BAD_REQUEST.getHttpStatus(),
                List.of(new FieldCustomError(ex.getRequestPartName(), ex.getMessage())));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseDTO handleValidationExceptions(MethodArgumentNotValidException ex) {
        log.error("Validation error: {}", ex.getMessage());
        List<FieldCustomError> fieldCustomErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                fieldCustomErrors.add(new FieldCustomError(error.getField(), error.getDefaultMessage())));
        return new ErrorResponseDTO(ResponseCode.BAD_REQUEST.name(),
                ResponseCode.BAD_REQUEST.getMessage(),
                ResponseCode.BAD_REQUEST.getHttpStatus(),
                fieldCustomErrors);
    }

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponseDTO> handleCustomException(ApiException ex) {
        return new ResponseEntity<>(
                new ErrorResponseDTO(ex.getCode(),
                        ex.getMessage(),
                        ex.getHttpStatus()
                ),
                HttpStatusCode.valueOf(ex.getHttpStatus())
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponseDTO handleException(Exception ex) {
        log.error("Unexpected error: {}", ex.getMessage());
        return new ErrorResponseDTO(ResponseCode.UNEXPECTED_ERROR.name(),
                ResponseCode.UNEXPECTED_ERROR.getMessage(),
                ResponseCode.UNEXPECTED_ERROR.getHttpStatus());
    }
}