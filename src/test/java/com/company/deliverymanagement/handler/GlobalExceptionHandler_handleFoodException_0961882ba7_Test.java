package com.company.deliverymanagement.handler;

import com.company.deliverymanagement.dto.response.ExceptionResponse;
import com.company.deliverymanagement.enums.ExceptionEnum;
import com.company.deliverymanagement.exception.FoodNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandler_handleFoodException_0961882ba7_Test {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testHandleFoodException() {
        FoodNotFoundException exception = new FoodNotFoundException(ExceptionEnum.FOOD_NOT_FOUND_EXCEPTION.getMessage());
        ExceptionResponse response = globalExceptionHandler.handleFoodException(exception);
        assertEquals(ExceptionEnum.FOOD_NOT_FOUND_EXCEPTION.getMessage(), response.getMessage());
    }

    @Test
    public void testHandleFoodExceptionWithTime() {
        FoodNotFoundException exception = new FoodNotFoundException(ExceptionEnum.FOOD_NOT_FOUND_EXCEPTION.getMessage());
        ExceptionResponse response = globalExceptionHandler.handleFoodException(exception);
        LocalDateTime now = LocalDateTime.now();
        // TODO: Change the expected time to match the actual time
        assertEquals(now, response.getLocalDateTime());
    }
}
