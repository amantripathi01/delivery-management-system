package com.company.deliverymanagement.entity;

import com.company.deliverymanagement.entity.model.AppUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppUserDetails_getPassword_e2bb0e63a1_Test {
    private AppUser appUser;

    @BeforeEach
    public void setUp() {
        appUser = Mockito.mock(AppUser.class);
        Mockito.when(appUser.getPassword()).thenReturn("testPassword");
    }

    @Test
    public void testGetPassword_Success() {
        String password = appUser.getPassword();
        assertEquals("testPassword", password);
    }

    @Test
    public void testGetPassword_Failure() {
        Mockito.when(appUser.getPassword()).thenReturn("wrongPassword");
        String password = appUser.getPassword();
        assertEquals("wrongPassword", password);
    }
}
