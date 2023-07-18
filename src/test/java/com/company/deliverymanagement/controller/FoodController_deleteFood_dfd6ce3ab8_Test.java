package com.company.deliverymanagement.controller;

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

public class FoodController_deleteFood_dfd6ce3ab8_Test {

    @InjectMocks
    private FoodController foodController;

    @Mock
    private FoodService foodService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        foodController = new FoodController();
        foodService = new FoodService();
    }

    @Test
    public void testDeleteFood_success() {
        Long id = 1L;
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Food deleted successfully");

        when(foodService.delete(id)).thenReturn(ResponseEntity.ok(responseDto));

        ResponseEntity<ResponseDto> result = foodController.deleteFood(id);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(responseDto, result.getBody());
        verify(foodService, times(1)).delete(id);
    }

    @Test
    public void testDeleteFood_failure() {
        Long id = 2L;
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Food not found");

        when(foodService.delete(id)).thenReturn(ResponseEntity.badRequest().body(responseDto));

        ResponseEntity<ResponseDto> result = foodController.deleteFood(id);

        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertEquals(responseDto, result.getBody());
        verify(foodService, times(1)).delete(id);
    }
}
