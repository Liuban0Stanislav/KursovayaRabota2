package com.example.kursovayarabota2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NullCollectionException extends RuntimeException{
    public NullCollectionException() {
    }

    public NullCollectionException(String message) {
        super(message);
    }

    public NullCollectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullCollectionException(Throwable cause) {
        super(cause);
    }

    public NullCollectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
