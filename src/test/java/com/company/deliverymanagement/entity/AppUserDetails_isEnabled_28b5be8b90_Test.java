package com.company.deliverymanagement.entity;

import com.company.deliverymanagement.entity.model.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AppUserDetails_isEnabled_28b5be8b90_Test {

    @Mock
    AppUser appUser;

    @InjectMocks
    AppUserDetails appUserDetails;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIsEnabledWhenUserIsEnabled() {
        when(appUser.getIsEnabled()).thenReturn(true);
        assertTrue(appUserDetails.isEnabled());
    }

    @Test
    public void testIsEnabledWhenUserIsDisabled() {
        when(appUser.getIsEnabled()).thenReturn(false);
        assertFalse(appUserDetails.isEnabled());
    }
}
