package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.request.CategoryRequestDto;
import com.company.deliverymanagement.dto.response.CategoryResponseDto;
import com.company.deliverymanagement.dto.response.ResponseDto;
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

public class CategoryController_updateCategory_8136f2e1ae_Test {

    @InjectMocks
    CategoryController categoryController = new CategoryController();

    @Mock
    CategoryService categoryService = new CategoryService();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateCategorySuccess() {
        CategoryRequestDto categoryDtoRequest = new CategoryRequestDto();
        categoryDtoRequest.setId(1L);
        categoryDtoRequest.setName("Category1");

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Category updated successfully");

        when(categoryService.update(categoryDtoRequest)).thenReturn(responseDto);

        ResponseEntity<ResponseDto> responseEntity = categoryController.updateCategory(1L, categoryDtoRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Category updated successfully", responseEntity.getBody().getMessage());
    }

    @Test
    public void testUpdateCategoryFailure() {
        CategoryRequestDto categoryDtoRequest = new CategoryRequestDto();
        categoryDtoRequest.setId(1L);
        categoryDtoRequest.setName("Category1");

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Failed to update category");

        when(categoryService.update(categoryDtoRequest)).thenReturn(responseDto);

        ResponseEntity<ResponseDto> responseEntity = categoryController.updateCategory(1L, categoryDtoRequest);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Failed to update category", responseEntity.getBody().getMessage());
    }
}
