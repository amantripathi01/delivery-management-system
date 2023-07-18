package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.response.CategoryResponseDto;
import com.company.deliverymanagement.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CategoryController_getCategoryById_6ddcea86ce_Test {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCategoryById_Success() {
        Long id = 1L;
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(id);
        categoryResponseDto.setName("Test Category");

        when(categoryService.findById(id)).thenReturn(categoryResponseDto);

        ResponseEntity<CategoryResponseDto> response = categoryController.getCategoryById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(categoryResponseDto, response.getBody());
    }

    @Test
    public void testGetCategoryById_NotFound() {
        Long id = 1L;

        when(categoryService.findById(id)).thenReturn(null);

        ResponseEntity<CategoryResponseDto> response = categoryController.getCategoryById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
