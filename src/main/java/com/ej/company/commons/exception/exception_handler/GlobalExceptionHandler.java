package com.ej.company.commons.exception.exception_handler;

import com.ej.company.commons.exception.exceptions.CommonApiExceptions;
import javax.persistence.EntityNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 공통 예외처리 핸들러
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 공통 예외 핸들러
     */
    @ExceptionHandler(value = {CommonApiExceptions.class})
    public ResponseEntity<ErrorResponse> commonApiExceptions(final CommonApiExceptions e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ErrorResponse.builder()
                                .errorCode(e.getError().getCode())
                                .errorMessage(e.getError().getMessage())
                                .detail(e.getDetail())
                                .build()
                );
    }

    /**
     *  중복 예외 처리
     */
    @ExceptionHandler(value = {DuplicateKeyException.class})
    public ResponseEntity<ErrorResponse> duplicateKeyException(final DuplicateKeyException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ErrorResponse.builder()
                                .errorCode(ExceptionType.DUPLICATE_KEY_EXCEPTION.getCode())
                                .errorMessage(ExceptionType.DUPLICATE_KEY_EXCEPTION.getMessage())
                                .detail(e.getMessage())
                                .build()
                );

    }

    /**
     * 파라미터 유효하지 않을 때 에외(dto 등..)
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(final MethodArgumentNotValidException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ErrorResponse.builder()
                                .errorCode(ExceptionType.PARAMETER_VALUE_ILLEGAL.getCode())
                                .errorMessage(ExceptionType.PARAMETER_VALUE_ILLEGAL.getMessage())
                                .detail(e.getMessage())
                                .build()
                );

    }


    /**
     * 엔티티 없을 때
     */
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ErrorResponse> entityNotFoundException(final EntityNotFoundException e){
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse.builder()
                    .errorCode(ExceptionType.ENTITY_NOT_FOUND_EXCEPTION.getCode())
                    .errorMessage(ExceptionType.ENTITY_NOT_FOUND_EXCEPTION.getMessage())
                    .detail(e.getMessage())
                    .build()
            );

    }


}
