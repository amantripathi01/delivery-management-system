package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.service.impl.AppUserDetailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerController_verifyToken_478fedf690_Test {

    @InjectMocks
    CustomerController customerController;

    @Mock
    AppUserDetailServiceImpl appUserDetailService;

    @BeforeEach
    public void setUp() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void testVerifyTokenSuccess() {
        String token = "validToken"; // TODO: replace with a valid token
        when(appUserDetailService.verifyPasswordResetToken(token)).thenReturn(true);

        ResponseEntity<Void> responseEntity = customerController.verifyToken(token);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testVerifyTokenFailure() {
        String token = "invalidToken"; // TODO: replace with an invalid token
        when(appUserDetailService.verifyPasswordResetToken(token)).thenReturn(false);

        ResponseEntity<Void> responseEntity = customerController.verifyToken(token);

        assertEquals(400, responseEntity.getStatusCodeValue());
    }
}
