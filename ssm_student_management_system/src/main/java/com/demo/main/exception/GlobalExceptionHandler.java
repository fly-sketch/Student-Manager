package com.demo.main.exception;

import com.demo.main.utils.Result;
import com.demo.main.utils.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotLoggedInException.class)
    public ResponseEntity<Result<String>> notLoggedInException(NotLoggedInException e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Result<>(ResultCode.FAILURE, "用户未登录"));
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Result<String>> handleException(UnauthorizedException e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Result<>(ResultCode.FAILURE, "未授权"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<String>> handleException(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Result<>(ResultCode.FAILURE, "服务器内部错误，请查看控制台"));
    }
}
