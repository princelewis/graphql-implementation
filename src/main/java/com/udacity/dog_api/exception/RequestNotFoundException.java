package com.udacity.dog_api.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "You passed a wrong ID")
public class RequestNotFoundException extends RuntimeException{

    private String id;

    public RequestNotFoundException(String message, String id) {
        super(message);
        this.id = id;
    }
}
