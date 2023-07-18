package com.company.deliverymanagement.handler;

import com.company.deliverymanagement.dto.response.ExceptionResponse;
import com.company.deliverymanagement.enums.ExceptionEnum;
import com.company.deliverymanagement.exception.OrderNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandler_handleOrderException_e4f70f275b_Test {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHandleOrderException() {
        OrderNotFoundException exception = new OrderNotFoundException();
        exception.setMessage(ExceptionEnum.ORDER_NOT_FOUND_EXCEPTION.getMessage());

        ExceptionResponse expectedResponse = new ExceptionResponse();
        expectedResponse.setMessage(ExceptionEnum.ORDER_NOT_FOUND_EXCEPTION.getMessage());

        ExceptionResponse actualResponse = globalExceptionHandler.handleOrderException(exception);

        assertEquals(expectedResponse.getMessage(), actualResponse.getMessage());
    }

    @Test
    public void testHandleOrderExceptionWithDifferentMessage() {
        OrderNotFoundException exception = new OrderNotFoundException();
        exception.setMessage("Different message");

        ExceptionResponse expectedResponse = new ExceptionResponse();
        expectedResponse.setMessage("Different message");

        ExceptionResponse actualResponse = globalExceptionHandler.handleOrderException(exception);

        assertEquals(expectedResponse.getMessage(), actualResponse.getMessage());
    }
}
