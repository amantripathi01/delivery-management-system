package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.response.FoodResponseDto;
import com.company.deliverymanagement.service.FoodService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FoodController_getAllFoods_e2178c87f8_Test {

    @Mock
    FoodService foodService;

    @InjectMocks
    FoodController foodController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllFoods_success() {
        FoodResponseDto food1 = new FoodResponseDto();
        FoodResponseDto food2 = new FoodResponseDto();
        List<FoodResponseDto> foodList = Arrays.asList(food1, food2);

        when(foodService.findAll()).thenReturn(foodList);

        ResponseEntity<List<FoodResponseDto>> response = foodController.getAllFoods();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(foodList, response.getBody());
    }

    @Test
    void testGetAllFoods_noFoods() {
        when(foodService.findAll()).thenReturn(null);

        ResponseEntity<List<FoodResponseDto>> response = foodController.getAllFoods();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}
