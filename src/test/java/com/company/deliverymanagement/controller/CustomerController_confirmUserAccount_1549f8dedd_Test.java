package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.service.impl.AppUserDetailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomerController_confirmUserAccount_1549f8dedd_Test {

    @InjectMocks
    private CustomerController customerController = new CustomerController();

    @Mock
    private AppUserDetailServiceImpl appUserDetailService = new AppUserDetailServiceImpl();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testConfirmUserAccountSuccess() {
        String token = "testToken";

        ResponseEntity<?> expectedResponse = ResponseEntity.ok().build();

        when(appUserDetailService.confirmEmail(token)).thenReturn(expectedResponse);

        ResponseEntity<?> actualResponse = customerController.confirmUserAccount(token);

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testConfirmUserAccountFailure() {
        String token = "testToken";

        ResponseEntity<?> expectedResponse = ResponseEntity.badRequest().build();

        when(appUserDetailService.confirmEmail(token)).thenReturn(expectedResponse);

        ResponseEntity<?> actualResponse = customerController.confirmUserAccount(token);

        assertEquals(expectedResponse, actualResponse);
    }
}
