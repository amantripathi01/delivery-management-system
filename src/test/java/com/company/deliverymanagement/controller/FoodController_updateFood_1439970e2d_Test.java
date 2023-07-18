package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.request.FoodRequestDto;
import com.company.deliverymanagement.dto.response.FoodResponseDto;
import com.company.deliverymanagement.dto.response.ResponseDto;
import com.company.deliverymanagement.service.FoodService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FoodController_updateFood_1439970e2d_Test {

    @InjectMocks
    private FoodController foodController;

    @Mock
    private FoodService foodService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateFood_success() {
        Long id = 1L;
        FoodRequestDto foodRequestDto = new FoodRequestDto();
        // TODO: Set properties of foodRequestDto

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Food updated successfully");
        when(foodService.update(foodRequestDto)).thenReturn(responseDto);

        ResponseEntity<ResponseDto> responseEntity = foodController.updateFood(id, foodRequestDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Food updated successfully", responseEntity.getBody().getMessage());
    }

    @Test
    public void testUpdateFood_failure() {
        Long id = 1L;
        FoodRequestDto foodRequestDto = new FoodRequestDto();
        // TODO: Set properties of foodRequestDto

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Failed to update food");
        when(foodService.update(foodRequestDto)).thenReturn(responseDto);

        ResponseEntity<ResponseDto> responseEntity = foodController.updateFood(id, foodRequestDto);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Failed to update food", responseEntity.getBody().getMessage());
    }
}
