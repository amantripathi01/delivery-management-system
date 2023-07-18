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
import static org.mockito.Mockito.*;

public class DriverController_createDriver_14210f091b_Test {

    @InjectMocks
    private DriverController driverController = new DriverController();

    @Mock
    private DriverService driverService = new DriverService();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateDriver_success() {
        DriverRequestDto driverRequestDto = new DriverRequestDto();
        // TODO: Set the values for driverRequestDto

        ResponseDto responseDto = new ResponseDto();
        // TODO: Set the values for responseDto

        when(driverService.insert(driverRequestDto)).thenReturn(new ResponseEntity<>(responseDto, HttpStatus.CREATED));

        ResponseEntity<ResponseDto> result = driverController.createDriver(driverRequestDto);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(responseDto, result.getBody());

        verify(driverService, times(1)).insert(driverRequestDto);
    }

    @Test
    public void testCreateDriver_failure() {
        DriverRequestDto driverRequestDto = new DriverRequestDto();
        // TODO: Set the values for driverRequestDto

        when(driverService.insert(driverRequestDto)).thenReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

        ResponseEntity<ResponseDto> result = driverController.createDriver(driverRequestDto);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());

        verify(driverService, times(1)).insert(driverRequestDto);
    }
}
