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
import static org.mockito.Mockito.*;

public class FoodController_createFood_407d66ccaf_Test {
    
    @InjectMocks
    private FoodController foodController = new FoodController();
    
    @Mock
    private FoodService foodService = new FoodService();
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testCreateFood_Success() {
        // Arrange
        FoodRequestDto foodRequestDto = new FoodRequestDto();
        // TODO: set properties for foodRequestDto
        ResponseDto responseDto = new ResponseDto();
        // TODO: set properties for responseDto
        when(foodService.insert(foodRequestDto)).thenReturn(new ResponseEntity<>(responseDto, HttpStatus.CREATED));
        
        // Act
        ResponseEntity<ResponseDto> result = foodController.createFood(foodRequestDto);
        
        // Assert
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(responseDto, result.getBody());
    }
    
    @Test
    public void testCreateFood_Failure() {
        // Arrange
        FoodRequestDto foodRequestDto = new FoodRequestDto();
        // TODO: set properties for foodRequestDto
        when(foodService.insert(foodRequestDto)).thenReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
        
        // Act
        ResponseEntity<ResponseDto> result = foodController.createFood(foodRequestDto);
        
        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }
}
