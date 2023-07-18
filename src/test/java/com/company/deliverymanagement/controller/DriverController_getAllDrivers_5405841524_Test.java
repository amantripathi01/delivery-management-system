package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.response.DriverResponseDto;
import com.company.deliverymanagement.service.DriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DriverController_getAllDrivers_5405841524_Test {

    @InjectMocks
    DriverController driverController = new DriverController();

    @Mock
    DriverService driverService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllDriversSuccess() {
        DriverResponseDto driver1 = new DriverResponseDto();
        driver1.setId(1);
        driver1.setName("Driver 1");

        DriverResponseDto driver2 = new DriverResponseDto();
        driver2.setId(2);
        driver2.setName("Driver 2");

        List<DriverResponseDto> drivers = Arrays.asList(driver1, driver2);

        when(driverService.findAll()).thenReturn(drivers);

        ResponseEntity<List<DriverResponseDto>> response = driverController.getAllDrivers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(drivers, response.getBody());
    }

    @Test
    public void testGetAllDriversEmptyList() {
        List<DriverResponseDto> drivers = Arrays.asList();

        when(driverService.findAll()).thenReturn(drivers);

        ResponseEntity<List<DriverResponseDto>> response = driverController.getAllDrivers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(drivers, response.getBody());
    }
}
