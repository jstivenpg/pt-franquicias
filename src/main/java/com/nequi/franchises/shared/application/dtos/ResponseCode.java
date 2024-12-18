package com.nequi.franchises.shared.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    // SUCCESS
    TRANSACTION_SUCCESS("APP_SS_01", 200, "Transaction success"),
    // ERROR
    UNEXPECTED_ERROR("APP_GE_01", 500, "Unexpected error"),
    BAD_REQUEST("APP_GE_02", 400, "Bad request"),
    BRANCH_NOT_FOUND("APP_GE_03", 404, "Branch not found"),
    BRANCH_NOT_DELETED("APP_GE_04", 400, "Branch not deleted");

    private final String code;
    private final int httpStatus;
    private final String message;


    public String formatMessage(Object... args) {
        return String.format(this.message, args);
    }
}