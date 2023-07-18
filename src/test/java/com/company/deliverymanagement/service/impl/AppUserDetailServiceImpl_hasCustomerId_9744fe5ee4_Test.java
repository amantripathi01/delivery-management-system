package com.company.deliverymanagement.service.impl;

import com.company.deliverymanagement.entity.AppUser;
import com.company.deliverymanagement.repository.AppUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppUserDetailServiceImpl_hasCustomerId_9744fe5ee4_Test {

    @InjectMocks
    private AppUserDetailServiceImpl appUserDetailService;

    @Mock
    private AppUserRepository appUserRepository;

    @Test
    public void testHasCustomerId_UserExistsAndIdMatches() {
        Authentication authentication = new UsernamePasswordAuthenticationToken("testUser", "password");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        when(appUserRepository.findByUsername("testUser")).thenReturn(Optional.of(appUser));

        assertTrue(appUserDetailService.hasCustomerId(authentication, 1L));
    }

    @Test
    public void testHasCustomerId_UserExistsAndIdDoesNotMatch() {
        Authentication authentication = new UsernamePasswordAuthenticationToken("testUser", "password");
        AppUser appUser = new AppUser();
        appUser.setId(2L);
        when(appUserRepository.findByUsername("testUser")).thenReturn(Optional.of(appUser));

        assertFalse(appUserDetailService.hasCustomerId(authentication, 1L));
    }

    @Test
    public void testHasCustomerId_UserDoesNotExist() {
        Authentication authentication = new UsernamePasswordAuthenticationToken("testUser", "password");
        when(appUserRepository.findByUsername("testUser")).thenReturn(Optional.empty());

        assertFalse(appUserDetailService.hasCustomerId(authentication, 1L));
    }
}
