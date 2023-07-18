package com.company.deliverymanagement.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.company.deliverymanagement.enums.ExceptionEnum;

public class DriverNotFoundExceptionTest {

    private DriverNotFoundException driverNotFoundException;

    @BeforeEach
    public void setUp() {
        driverNotFoundException = new DriverNotFoundException(ExceptionEnum.DRIVER_NOT_FOUND_EXCEPTION.getMessage());
    }

    @Test
    public void testDriverNotFoundExceptionMessage() {
        assertEquals(ExceptionEnum.DRIVER_NOT_FOUND_EXCEPTION.getMessage(), driverNotFoundException.getMessage());
    }

    @Test
    public void testDriverNotFoundExceptionCause() {
        assertNull(driverNotFoundException.getCause());
    }
}
