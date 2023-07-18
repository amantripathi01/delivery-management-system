package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.request.DriverRequestDto;
import com.company.deliverymanagement.dto.response.DriverResponseDto;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class DriverController_updateFood_a332b6262f_Test {

    @InjectMocks
    private DriverController driverController;

    @Mock
    private DriverService driverService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUpdateFood_success() {
        DriverRequestDto driverRequestDto = new DriverRequestDto();
        // TODO: Set appropriate values in driverRequestDto

        ResponseDto responseDto = new ResponseDto();
        // TODO: Set appropriate values in responseDto

        when(driverService.updateFindById(any(Long.class), any(DriverRequestDto.class))).thenReturn(new ResponseEntity<>(responseDto, HttpStatus.OK));

        ResponseEntity<ResponseDto> result = driverController.updateFood(1L, driverRequestDto);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(responseDto, result.getBody());
    }

    @Test
    void testUpdateFood_failure() {
        DriverRequestDto driverRequestDto = new DriverRequestDto();
        // TODO: Set appropriate values in driverRequestDto

        when(driverService.updateFindById(any(Long.class), any(DriverRequestDto.class))).thenReturn(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        ResponseEntity<ResponseDto> result = driverController.updateFood(1L, driverRequestDto);

        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }
}
