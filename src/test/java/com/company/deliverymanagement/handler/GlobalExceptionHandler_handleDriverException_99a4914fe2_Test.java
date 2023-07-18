package com.company.deliverymanagement.handler;

import com.company.deliverymanagement.dto.response.ExceptionResponse;
import com.company.deliverymanagement.enums.ExceptionEnum;
import com.company.deliverymanagement.exception.DriverNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GlobalExceptionHandler_handleDriverException_99a4914fe2_Test {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHandleDriverException() {
        DriverNotFoundException driverNotFoundException = new DriverNotFoundException();
        driverNotFoundException.setMessage(ExceptionEnum.DRIVER_NOT_FOUND_EXCEPTION.getMessage());
        ExceptionResponse exceptionResponse = globalExceptionHandler.handleDriverException(driverNotFoundException);
        assertEquals(ExceptionEnum.DRIVER_NOT_FOUND_EXCEPTION.getMessage(), exceptionResponse.getMessage());
    }

    @Test
    public void testHandleDriverExceptionWithDifferentMessage() {
        DriverNotFoundException driverNotFoundException = new DriverNotFoundException();
        driverNotFoundException.setMessage("Different Message");
        ExceptionResponse exceptionResponse = globalExceptionHandler.handleDriverException(driverNotFoundException);
        assertNotEquals("Different Message", exceptionResponse.getMessage());
    }
}
