package com.company.deliverymanagement.entity;

import com.company.deliverymanagement.entity.model.AppUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AppUserDetails_isCredentialsNonExpired_3b7b043533_Test {

    @Mock
    private AppUser appUser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testIsCredentialsNonExpired_Success() {
        Mockito.when(appUser.isCredentialsNonExpired()).thenReturn(true);

        boolean result = appUser.isCredentialsNonExpired();
        Assertions.assertTrue(result, "Expected credentials to be non-expired");
    }

    @Test
    public void testIsCredentialsNonExpired_Failure() {
        Mockito.when(appUser.isCredentialsNonExpired()).thenReturn(false);

        boolean result = appUser.isCredentialsNonExpired();
        Assertions.assertFalse(result, "Expected credentials to be expired");
    }
}
