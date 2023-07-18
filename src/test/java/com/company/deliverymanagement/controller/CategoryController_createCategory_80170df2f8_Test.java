package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.request.CategoryRequestDto;
import com.company.deliverymanagement.dto.response.ResponseDto;
import com.company.deliverymanagement.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryController_createCategory_80170df2f8_Test {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    private CategoryRequestDto categoryRequestDto;
    private ResponseDto responseDto;

    @BeforeEach
    public void setUp() {
        categoryRequestDto = new CategoryRequestDto();
        responseDto = new ResponseDto();
        
        categoryRequestDto.setName("Test Category");
        responseDto.setMessage("Category created successfully");
    }

    @Test
    public void testCreateCategory_Success() {
        when(categoryService.insert(categoryRequestDto)).thenReturn(new ResponseEntity<>(responseDto, HttpStatus.CREATED));
        ResponseEntity<ResponseDto> responseEntity = categoryController.createCategory(categoryRequestDto);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(responseDto, responseEntity.getBody());
    }

    @Test
    public void testCreateCategory_Failure() {
        when(categoryService.insert(categoryRequestDto)).thenReturn(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        ResponseEntity<ResponseDto> responseEntity = categoryController.createCategory(categoryRequestDto);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}
