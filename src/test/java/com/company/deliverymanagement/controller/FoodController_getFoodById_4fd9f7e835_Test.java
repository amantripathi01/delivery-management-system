package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.request.FoodRequestDto;
import com.company.deliverymanagement.dto.response.FoodResponseDto;
import com.company.deliverymanagement.dto.response.ResponseDto;
import com.company.deliverymanagement.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Slf4j
public class FoodController_getFoodById_4fd9f7e835_Test {

    @InjectMocks
    private FoodController foodController = new FoodController();

    @Mock
    private FoodService foodService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFoodById_Success() {
        Long id = 1L; // TODO: Change this to the ID of the food item you want to test
        FoodResponseDto foodResponseDto = new FoodResponseDto();
        foodResponseDto.setId(id);
        when(foodService.findById(id)).thenReturn(foodResponseDto);

        ResponseEntity<FoodResponseDto> response = foodController.getFoodById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(id, response.getBody().getId());
    }

    @Test
    public void testGetFoodById_Failure() {
        Long id = 1L; // TODO: Change this to the ID of the food item you want to test
        when(foodService.findById(id)).thenReturn(null);

        ResponseEntity<FoodResponseDto> response = foodController.getFoodById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}
