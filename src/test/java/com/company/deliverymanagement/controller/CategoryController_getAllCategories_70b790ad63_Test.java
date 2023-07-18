package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.response.CategoryResponseDto;
import com.company.deliverymanagement.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CategoryController_getAllCategories_70b790ad63_Test {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCategories_success() {
        CategoryResponseDto category1 = new CategoryResponseDto();
        CategoryResponseDto category2 = new CategoryResponseDto();
        List<CategoryResponseDto> categories = Arrays.asList(category1, category2);

        when(categoryService.findAll()).thenReturn(categories);

        ResponseEntity<List<CategoryResponseDto>> response = categoryController.getAllCategories();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetAllCategories_noData() {
        when(categoryService.findAll()).thenReturn(null);

        ResponseEntity<List<CategoryResponseDto>> response = categoryController.getAllCategories();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(null, response.getBody());
    }

}
