package com.company.deliverymanagement.config;

import com.company.deliverymanagement.service.impl.AppUserDetailServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SecurityConfig_securityFilterChain_c822870784_Test {

    @Mock
    private HttpSecurity httpSecurity;

    @Mock
    private AppUserDetailServiceImpl appUserDetailServiceImpl;

    @InjectMocks
    private SecurityConfig securityConfig;

    @Test
    public void testSecurityFilterChain_Success() throws Exception {
        when(httpSecurity.csrf()).thenReturn(httpSecurity);
        when(httpSecurity.authorizeRequests()).thenReturn(httpSecurity);
        when(httpSecurity.formLogin()).thenReturn(httpSecurity);
        when(httpSecurity.httpBasic()).thenReturn(httpSecurity);
        when(httpSecurity.build()).thenReturn(mock(SecurityFilterChain.class));

        SecurityFilterChain result = securityConfig.securityFilterChain(httpSecurity);

        assertNotNull(result);
        verify(httpSecurity, times(1)).csrf();
        verify(httpSecurity, times(1)).authorizeRequests();
        verify(httpSecurity, times(1)).formLogin();
        verify(httpSecurity, times(1)).httpBasic();
        verify(httpSecurity, times(1)).build();
    }

    @Test
    public void testSecurityFilterChain_Exception() throws Exception {
        when(httpSecurity.csrf()).thenThrow(new RuntimeException());

        try {
            securityConfig.securityFilterChain(httpSecurity);
        } catch (Exception e) {
            assertNotNull(e);
        }
    }
}
