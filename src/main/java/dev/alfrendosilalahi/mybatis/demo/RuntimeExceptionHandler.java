package dev.alfrendosilalahi.mybatis.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RuntimeExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class, produces = MediaType.TEXT_PLAIN_VALUE)
    public String handleRuntimeException(RuntimeException e) {
        return e.getMessage();
    }

}
