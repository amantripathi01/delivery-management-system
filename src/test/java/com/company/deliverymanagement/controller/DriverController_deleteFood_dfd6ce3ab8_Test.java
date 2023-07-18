package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.response.ResponseDto;
import com.company.deliverymanagement.service.DriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DriverController_deleteFood_dfd6ce3ab8_Test {

    @InjectMocks
    private DriverController driverController;

    @Mock
    private DriverService driverService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeleteFood_Success() {
        Long id = 1L;
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Driver deleted successfully");

        when(driverService.delete(id)).thenReturn(ResponseEntity.ok(responseDto));

        ResponseEntity<ResponseDto> responseEntity = driverController.deleteFood(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Driver deleted successfully", responseEntity.getBody().getMessage());
    }

    @Test
    public void testDeleteFood_Failure() {
        Long id = 1L;
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Driver not found");

        when(driverService.delete(id)).thenReturn(ResponseEntity.badRequest().body(responseDto));

        ResponseEntity<ResponseDto> responseEntity = driverController.deleteFood(id);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Driver not found", responseEntity.getBody().getMessage());
    }
}
