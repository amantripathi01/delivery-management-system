package com.company.deliverymanagement.entity;

import com.company.deliverymanagement.entity.model.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppUserDetails_getUsername_e813cd2b29_Test {

    private UserDetails userDetails;

    @BeforeEach
    public void setUp() {
        userDetails = Mockito.mock(UserDetails.class);
    }

    @Test
    public void testGetUsernameSuccess() {
        String expectedUsername = "TestUser";
        Mockito.when(userDetails.getUsername()).thenReturn(expectedUsername);

        String actualUsername = userDetails.getUsername();
        assertEquals(expectedUsername, actualUsername, "Username should match the expected value");
    }

    @Test
    public void testGetUsernameNull() {
        Mockito.when(userDetails.getUsername()).thenReturn(null);

        String actualUsername = userDetails.getUsername();
        assertEquals(null, actualUsername, "Username should be null");
    }
}
