package com.nequi.franchises.shared.application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@AllArgsConstructor
public class FieldCustomError implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String field;
    private String error;
}