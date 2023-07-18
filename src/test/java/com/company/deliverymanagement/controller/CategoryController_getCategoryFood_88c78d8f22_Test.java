package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.response.FoodResponseDto;
import com.company.deliverymanagement.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryController_getCategoryFood_88c78d8f22_Test {

    @InjectMocks
    private CategoryController categoryController = new CategoryController();

    @Mock
    private CategoryService categoryService = new CategoryService();

    @Test
    public void testGetCategoryFood_Success() {
        Long id = 1L;
        FoodResponseDto foodResponseDto = new FoodResponseDto();
        foodResponseDto.setId(id);
        foodResponseDto.setName("Test Food");
        List<FoodResponseDto> foodResponseDtoList = Arrays.asList(foodResponseDto);

        when(categoryService.findAllFood(id)).thenReturn(foodResponseDtoList);

        ResponseEntity<List<FoodResponseDto>> response = categoryController.getCategoryFood(id);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(foodResponseDtoList, response.getBody());
    }

    @Test
    public void testGetCategoryFood_NotFound() {
        Long id = 1L;

        when(categoryService.findAllFood(id)).thenReturn(null);

        ResponseEntity<List<FoodResponseDto>> response = categoryController.getCategoryFood(id);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNull(response.getBody());
    }
}
