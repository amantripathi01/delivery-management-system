package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.request.CategoryRequestDto;
import com.company.deliverymanagement.dto.response.CategoryResponseDto;
import com.company.deliverymanagement.dto.response.FoodResponseDto;
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

public class CategoryController_deleteCategory_c17c3b6266_Test {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeleteCategory_Success() {
        Long id = 1L;
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Category deleted successfully");
        when(categoryService.delete(id)).thenReturn(new ResponseEntity<>(responseDto, HttpStatus.OK));

        ResponseEntity<ResponseDto> responseEntity = categoryController.deleteCategory(id);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Category deleted successfully", responseEntity.getBody().getMessage());
    }

    @Test
    public void testDeleteCategory_Failure() {
        Long id = 1L;
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Category not found");
        when(categoryService.delete(id)).thenReturn(new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND));

        ResponseEntity<ResponseDto> responseEntity = categoryController.deleteCategory(id);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Category not found", responseEntity.getBody().getMessage());
    }
}
