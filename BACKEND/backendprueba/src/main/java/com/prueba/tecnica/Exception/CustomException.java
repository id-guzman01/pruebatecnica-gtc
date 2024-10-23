package com.prueba.tecnica.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {

    private String message;
    private int statusCode;

    public CustomException(String message, int statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }

}
