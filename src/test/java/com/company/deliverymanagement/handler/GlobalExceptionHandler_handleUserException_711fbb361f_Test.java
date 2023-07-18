package com.company.deliverymanagement.handler;

import com.company.deliverymanagement.dto.response.ExceptionResponse;
import com.company.deliverymanagement.enums.ExceptionEnum;
import com.company.deliverymanagement.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandler_handleUserException_711fbb361f_Test {

    GlobalExceptionHandler globalExceptionHandler;
    ExceptionResponse exceptionResponse;

    @BeforeEach
    void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
        exceptionResponse = new ExceptionResponse();
        exceptionResponse.setLocalDateTime(LocalDateTime.now());
        exceptionResponse.setMessage(ExceptionEnum.USER_NOT_FOUND_EXCEPTION.getMessage());
    }

    @Test
    void testHandleUserException() {
        UserException userException = new UserException("");
        ExceptionResponse response = globalExceptionHandler.handleUserException(userException);
        assertNotNull(response);
        assertEquals(exceptionResponse.getMessage(), response.getMessage());
    }

    @Test
    void testHandleUserExceptionWithDifferentMessage() {
        UserException userException = new UserException("Different message");
        ExceptionResponse response = globalExceptionHandler.handleUserException(userException);
        assertNotEquals("Different message", response.getMessage());
    }
}
