package com.musinsa.category.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse<T> {
    private int code;
    private String message;
    private T data;
}
