package com.company.deliverymanagement.service.impl;

import com.company.deliverymanagement.entity.AppUser;
import com.company.deliverymanagement.exception.UsernameNotFoundException;
import com.company.deliverymanagement.repository.AppUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppUserDetailServiceImpl_loadUserByUsername_86995db6e4_Test {

    @InjectMocks
    private AppUserDetailServiceImpl appUserDetailService;

    @Mock
    private AppUserRepository appUserRepository;

    private AppUser appUser;

    @BeforeEach
    public void setup() {
        appUser = new AppUser();
        appUser.setUsername("testUser");
        appUser.setPassword("testPassword");
        appUser.setEnabled(true);
    }

    @Test
    public void testLoadUserByUsername_Success() {
        when(appUserRepository.findByUsernameAndIsEnabled("testUser", true)).thenReturn(Optional.of(appUser));

        UserDetails userDetails = appUserDetailService.loadUserByUsername("testUser");

        assertNotNull(userDetails);
        assertEquals("testUser", userDetails.getUsername());
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        when(appUserRepository.findByUsernameAndIsEnabled("testUser", true)).thenReturn(Optional.empty());

        Exception exception = assertThrows(UsernameNotFoundException.class, () -> {
            appUserDetailService.loadUserByUsername("testUser");
        });

        String expectedMessage = "Username not found! testUser";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
