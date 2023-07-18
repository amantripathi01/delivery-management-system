package com.company.deliverymanagement.exception;

import com.company.deliverymanagement.enums.ExceptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderNotFoundException_OrderNotFoundException_601d2609a5_Test {

    private OrderNotFoundException exception;

    @BeforeEach
    void setUp() {
        exception = new OrderNotFoundException();
    }

    @Test
    void testOrderNotFoundExceptionMessage() {
        String expectedMessage = ExceptionEnum.ORDER_NOT_FOUND_EXCEPTION.getMessage();
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage, "Exception message should match the ORDER_NOT_FOUND_EXCEPTION message");
    }

    @Test
    void testOrderNotFoundExceptionInstance() {
        assertTrue(exception instanceof OrderNotFoundException, "Exception should be an instance of OrderNotFoundException");
    }
}
