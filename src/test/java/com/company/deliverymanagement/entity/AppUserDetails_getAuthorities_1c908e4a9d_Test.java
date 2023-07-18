package com.company.deliverymanagement.entity;

import com.company.deliverymanagement.entity.model.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppUserDetails_getAuthorities_1c908e4a9d_Test {

    private AppUser appUser;

    @BeforeEach
    public void setup() {
        appUser = Mockito.mock(AppUser.class);
    }

    @Test
    public void testGetAuthorities() {
        Mockito.when(appUser.getRoles()).thenReturn(Arrays.asList("ROLE_ADMIN", "ROLE_USER"));
        Collection<GrantedAuthority> authorities = appUser.getRoles().stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

        assertEquals(2, authorities.size());
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Test
    public void testGetAuthoritiesWithNoRoles() {
        Mockito.when(appUser.getRoles()).thenReturn(Arrays.asList());
        Collection<GrantedAuthority> authorities = appUser.getRoles().stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

        assertTrue(authorities.isEmpty());
    }
}
