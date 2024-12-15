package com.musinsa.category.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {
    private HttpStatus status;
    private Object data;

    public CustomException(ErrorCode errorCode, Object data) {
        super(errorCode.getMessage());
        this.status = errorCode.getStatus();
        this.data = data;
    }
}
