package com.nequi.franchises.shared.application.exceptions;

import com.nequi.franchises.shared.application.dtos.ResponseCode;
import lombok.Getter;

import java.io.Serial;
import java.util.List;

@Getter
public class ApiException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    private final String code;
    private final String message;
    private final int httpStatus;
    private final List<FieldCustomError> fieldCustomErrors;

    public ApiException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.httpStatus = responseCode.getHttpStatus();
        this.fieldCustomErrors = null;
    }

    public ApiException(ResponseCode responseCode, List<FieldCustomError> fieldCustomErrors) {
        super(responseCode.getMessage());
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.httpStatus = responseCode.getHttpStatus();
        this.fieldCustomErrors = fieldCustomErrors;
    }

    public ApiException(ResponseCode responseCode, Object... args) {
        this.code = responseCode.getCode();
        this.message = responseCode.formatMessage(args);
        this.httpStatus = responseCode.getHttpStatus();
        this.fieldCustomErrors = null;
    }
}
