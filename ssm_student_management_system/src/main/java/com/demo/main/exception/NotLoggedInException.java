package com.demo.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NotLoggedInException extends UnauthorizedException {
    public NotLoggedInException(String message) {
        super(message);
    }
}
