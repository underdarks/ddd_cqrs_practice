package com.ej.company.commons.exception.exceptions;


import com.ej.company.commons.exception.exception_handler.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor(staticName = "of")
public class CommonApiExceptions extends RuntimeException {

    private ExceptionType error;
    private String detail;
}
