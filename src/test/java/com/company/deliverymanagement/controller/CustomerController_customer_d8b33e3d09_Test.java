package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.request.AppUserRequestDto;
import com.company.deliverymanagement.dto.response.AppUserResponseDto;
import com.company.deliverymanagement.service.impl.AppUserDetailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomerController_customer_d8b33e3d09_Test {

    @InjectMocks
    private CustomerController customerController = new CustomerController();

    @Mock
    private AppUserDetailServiceImpl appUserDetailService = new AppUserDetailServiceImpl();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCustomer_withExistingUser() {
        Long customerId = 1L;
        AppUserResponseDto appUserResponseDto = new AppUserResponseDto();
        appUserResponseDto.setId(customerId);
        when(appUserDetailService.findById(customerId)).thenReturn(Optional.of(appUserResponseDto));

        Optional<AppUserResponseDto> result = customerController.customer(customerId);

        assertEquals(Optional.of(appUserResponseDto), result);
    }

    @Test
    public void testCustomer_withNonExistingUser() {
        Long customerId = 1L;
        when(appUserDetailService.findById(customerId)).thenReturn(Optional.empty());

        Optional<AppUserResponseDto> result = customerController.customer(customerId);

        assertEquals(Optional.empty(), result);
    }
}
