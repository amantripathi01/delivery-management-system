package com.company.deliverymanagement.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.company.deliverymanagement.enums.ExceptionEnum;

public class AppUserNotFoundException_AppUserNotFoundException_19a458c833_Test {

    private AppUserNotFoundException exception;

    @BeforeEach
    public void setUp() {
        exception = new AppUserNotFoundException();
    }

    @Test
    public void testAppUserNotFoundExceptionMessage() {
        String expectedMessage = ExceptionEnum.USER_NOT_FOUND_EXCEPTION.getMessage();
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage, "Expected and actual messages do not match.");
    }

    @Test
    public void testAppUserNotFoundExceptionDefaultMessage() {
        AppUserNotFoundException defaultException = new AppUserNotFoundException();
        String expectedMessage = ExceptionEnum.USER_NOT_FOUND_EXCEPTION.getMessage();
        String actualMessage = defaultException.getMessage();

        assertEquals(expectedMessage, actualMessage, "Expected and actual messages for default exception do not match.");
    }
}
