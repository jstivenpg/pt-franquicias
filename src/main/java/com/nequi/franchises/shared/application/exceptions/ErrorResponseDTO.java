package com.nequi.franchises.shared.application.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponseDTO {
    private String code;
    private String message;
    private int httpStatus;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FieldCustomError> fieldCustomErrors;

    public ErrorResponseDTO(String code, String message, int httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ErrorResponseDTO(String code, String message, int httpStatus, List<FieldCustomError> fieldCustomErrors) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
        this.fieldCustomErrors = fieldCustomErrors;
    }

}