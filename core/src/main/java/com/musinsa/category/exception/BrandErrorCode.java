package com.musinsa.category.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public enum BrandErrorCode implements ErrorCode {
    NO_CONTENTS(HttpStatus.NO_CONTENT, "Brand 정보가 없습니다."),
    BRAND_EXIST(HttpStatus.BAD_REQUEST, "이미 존재하는 브랜드 입니다"),
    SAVE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Brand 정보 저장에 실패하였습니다"),
    UPDATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Brand 정보 업데이트에 실패하였습니다"),
    DELETE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Brand 정보 삭제에 실패하였습니다");
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
    BrandErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
