package com.company.deliverymanagement.entity;

import com.company.deliverymanagement.entity.model.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AppUserDetails_isAccountNonExpired_c1ce78f83f_Test {

    private AppUser appUser;

    @BeforeEach
    public void setUp() {
        appUser = new AppUser();
    }

    @Test
    public void testIsAccountNonExpired_WhenAccountIsNonExpired() {
        assertTrue(appUser.isAccountNonExpired());
    }

    @Test
    public void testIsAccountNonExpired_WhenAccountIsExpired() {
        appUser.setAccountNonExpired(false);
        assertFalse(appUser.isAccountNonExpired());
    }
}
