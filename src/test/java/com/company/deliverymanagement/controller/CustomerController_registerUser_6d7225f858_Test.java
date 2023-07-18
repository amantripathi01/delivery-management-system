package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.request.AppUserRequestDto;
import com.company.deliverymanagement.dto.response.AppUserResponseDto;
import com.company.deliverymanagement.service.impl.AppUserDetailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomerController_registerUser_6d7225f858_Test {
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private AppUserDetailServiceImpl appUserDetailService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser_Success() {
        AppUserRequestDto user = new AppUserRequestDto();
        user.setUsername("testUser");

        AppUserResponseDto responseDto = new AppUserResponseDto();
        responseDto.setMessage("User registered successfully");

        when(appUserDetailService.saveUser(user)).thenReturn(new ResponseEntity<>(responseDto, HttpStatus.CREATED));

        ResponseEntity<?> response = customerController.registerUser(user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(responseDto, response.getBody());
    }

    @Test
    public void testRegisterUser_Failure() {
        AppUserRequestDto user = new AppUserRequestDto();
        user.setUsername("testUser");

        AppUserResponseDto responseDto = new AppUserResponseDto();
        responseDto.setMessage("Username already exists");

        when(appUserDetailService.saveUser(user)).thenReturn(new ResponseEntity<>(responseDto, HttpStatus.CONFLICT));

        ResponseEntity<?> response = customerController.registerUser(user);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals(responseDto, response.getBody());
    }
}
