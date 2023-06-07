package com.ej.company.commons.exception.exception_handler;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * 공통 오류 코드 타입
 */
@Getter
@ToString
public enum ExceptionType {

    /**
     *                      Rule
     *
     * ErrorCode  = E + HTTP 응답코드 + 시퀀스(001 ~ 999)
     */

    ENTITY_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"E404000","엔티티를 찾을 수 없습니다."),
    DUPLICATE_VALUE_EXCEPTION(HttpStatus.BAD_REQUEST,"E400001","중복된 코드값이 존재합니다."),
    DUPLICATE_NAME_EXCEPTION(HttpStatus.BAD_REQUEST,"E400002","중복된 코드명이 존재합니다."),
    DUPLICATE_KEY_EXCEPTION(HttpStatus.BAD_REQUEST,"E400002","중복된 값이 존재합니다."),
    PARAMETER_VALUE_ILLEGAL(HttpStatus.BAD_REQUEST,"E400003","파라미터가 부적절합니다."),



    ;

    private final HttpStatus status;
    private final String code;
    private String message;

    ExceptionType(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ExceptionType(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
