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

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerController_resetPassword_03a543db85_Test {

    @Mock
    private AppUserDetailServiceImpl appUserDetailService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testResetPassword() {
        String token = "testToken";
        String newPassword = "newPassword";
        doNothing().when(appUserDetailService).resetPassword(token, newPassword);
        ResponseEntity<Void> response = customerController.resetPassword(token, newPassword);
        verify(appUserDetailService, times(1)).resetPassword(token, newPassword);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testResetPasswordWithInvalidToken() {
        String token = "invalidToken";
        String newPassword = "newPassword";
        doThrow(new IllegalArgumentException("Invalid token")).when(appUserDetailService).resetPassword(token, newPassword);
        assertThrows(IllegalArgumentException.class, () -> customerController.resetPassword(token, newPassword));
    }
}
