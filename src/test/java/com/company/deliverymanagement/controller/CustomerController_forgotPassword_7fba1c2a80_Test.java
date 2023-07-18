package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.request.AppUserRequestDto;
import com.company.deliverymanagement.dto.response.AppUserResponseDto;
import com.company.deliverymanagement.service.impl.AppUserDetailServiceImpl;
import com.company.deliverymanagement.controller.CustomerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerController_forgotPassword_7fba1c2a80_Test {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private AppUserDetailServiceImpl appUserDetailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testForgotPassword_Success() {
        String email = "test@example.com";
        doNothing().when(appUserDetailService).initiatePasswordReset(email);
        ResponseEntity<Void> responseEntity = customerController.forgotPassword(email);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(appUserDetailService, times(1)).initiatePasswordReset(email);
    }

    @Test
    void testForgotPassword_Failure() {
        String email = "test@example.com";
        doThrow(new RuntimeException()).when(appUserDetailService).initiatePasswordReset(email);

        assertThrows(RuntimeException.class, () -> {
            customerController.forgotPassword(email);
        });

        verify(appUserDetailService, times(1)).initiatePasswordReset(email);
    }
}
