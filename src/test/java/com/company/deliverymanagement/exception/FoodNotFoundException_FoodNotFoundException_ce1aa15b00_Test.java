package com.company.deliverymanagement.exception;

import com.company.deliverymanagement.enums.ExceptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FoodNotFoundException_FoodNotFoundException_ce1aa15b00_Test {

    private FoodNotFoundException exception;

    @BeforeEach
    public void setUp() {
        exception = new FoodNotFoundException();
    }

    @Test
    public void testFoodNotFoundExceptionMessage() {
        assertEquals("Food not found", exception.getMessage());
    }

    @Test
    public void testFoodNotFoundExceptionDefaultMessage() {
        FoodNotFoundException defaultException = new FoodNotFoundException();
        assertEquals("Food not found", defaultException.getMessage());
    }
}
