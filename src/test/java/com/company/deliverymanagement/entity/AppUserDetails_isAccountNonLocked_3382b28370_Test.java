package com.company.deliverymanagement.entity;

import com.company.deliverymanagement.entity.model.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
public class AppUserDetails_isAccountNonLocked_3382b28370_Test {

    @InjectMocks
    private AppUser appUser;

    @BeforeEach
    public void setUp() {
        // remove the manual creation of AppUser
    }

    @Test
    public void testIsAccountNonLocked_WhenAccountIsNotLocked() {
        // TODO: You need to set the account non-locked status to true before testing
        // appUser.setAccountNonLocked(true);
        assertTrue(appUser.isAccountNonLocked());
    }

    @Test
    public void testIsAccountNonLocked_WhenAccountIsLocked() {
        // TODO: You need to set the account non-locked status to false before testing
        // appUser.setAccountNonLocked(false);
        assertFalse(appUser.isAccountNonLocked());
    }
}
