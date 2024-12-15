package com.musinsa.category.dto;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GlobalApiResponse<T> {
    private int code;
    private String message;
    private T data;
    private GlobalApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> GlobalApiResponse ok(T data) {
        return new GlobalApiResponse(
                HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
                data
        );
    }
}