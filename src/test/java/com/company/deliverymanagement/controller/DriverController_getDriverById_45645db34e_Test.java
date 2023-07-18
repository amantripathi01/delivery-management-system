package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.response.DriverResponseDto;
import com.company.deliverymanagement.service.DriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DriverController_getDriverById_45645db34e_Test {

    @InjectMocks
    private DriverController driverController;

    @Mock
    private DriverService driverService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetDriverByIdSuccess() {
        Long id = 1L;
        DriverResponseDto driverResponseDto = new DriverResponseDto();
        driverResponseDto.setId(id);
        when(driverService.findById(id)).thenReturn(driverResponseDto);

        ResponseEntity<DriverResponseDto> response = driverController.getDriverById(id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(id, response.getBody().getId());
    }

    @Test
    public void testGetDriverByIdFailure() {
        Long id = 2L;
        when(driverService.findById(id)).thenReturn(null);

        ResponseEntity<DriverResponseDto> response = driverController.getDriverById(id);

        assertEquals(404, response.getStatusCodeValue());
        assertEquals(null, response.getBody());
    }
}
