package com.musinsa.category.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public enum CategoryErrorCode implements ErrorCode {
    NO_CONTENTS(HttpStatus.NO_CONTENT, "카테고리 이름의 최저, 최고 가격 브랜드와 상품 가격 정보가 없습니다.");
    private final HttpStatus status;
    private final String message;

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public HttpStatus getStatus() {
        return this.status;
    }
    CategoryErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
