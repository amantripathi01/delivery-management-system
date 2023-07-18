package com.company.deliverymanagement.service.impl;

import com.company.deliverymanagement.entity.AppUser;
import com.company.deliverymanagement.repository.AppUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AppUserDetailServiceImpl_hasCustomerId_492949a4f1_Test {
    @InjectMocks
    private AppUserDetailServiceImpl appUserDetailService;

    @Mock
    private AppUserRepository appUserRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHasCustomerIdSuccess() {
        String username = "testUser";
        Long customerId = 1L;
        AppUser appUser = new AppUser();
        appUser.setId(customerId);
        appUser.setUsername(username);

        Authentication authentication = new UsernamePasswordAuthenticationToken(username, "password");

        when(appUserRepository.findByUsername(username)).thenReturn(Optional.of(appUser));

        Boolean hasCustomerId = appUserDetailService.hasCustomerId(authentication);

        assertTrue(hasCustomerId);
    }

    @Test
    public void testHasCustomerIdFailure() {
        String username = "testUser";

        Authentication authentication = new UsernamePasswordAuthenticationToken(username, "password");

        when(appUserRepository.findByUsername(username)).thenReturn(Optional.empty());

        Boolean hasCustomerId = appUserDetailService.hasCustomerId(authentication);

        assertFalse(hasCustomerId);
    }
}
