package com.nequi.franchises.shared.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;

@Getter
@AllArgsConstructor
public class GeneralResponse <T> implements Serializable {
    private String status;
    private String message;
    private T data;

    public GeneralResponse(T data) {
        this.status = ResponseCode.TRANSACTION_SUCCESS.getCode();
        this.message = ResponseCode.TRANSACTION_SUCCESS.getMessage();
        this.data = data;
    }
}
