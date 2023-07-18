package com.company.deliverymanagement.handler;

import com.company.deliverymanagement.dto.response.ExceptionResponse;
import com.company.deliverymanagement.enums.ExceptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GlobalExceptionHandler_handleCategoryException_a19096545c_Test {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setup() {
        globalExceptionHandler = new GlobalExceptionHandler();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHandleCategoryException() {
        ExceptionResponse response = globalExceptionHandler.handleCategoryException();
        assertNotNull(response);
        assertEquals(ExceptionEnum.CATEGORY_NOT_FOUND_EXCEPTION.getMessage(), response.getMessage());
    }

    @Test
    public void testHandleCategoryException_timeNotNull() {
        ExceptionResponse response = globalExceptionHandler.handleCategoryException();
        assertNotNull(response.getLocalDateTime());
        assertEquals(LocalDateTime.class, response.getLocalDateTime().getClass());
    }
}
