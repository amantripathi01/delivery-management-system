package com.company.deliverymanagement.entity.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConfirmationTokenTest {

    @Test
    public void testConfirmationToken() {
        AppUser appUser = new AppUser();
        ConfirmationToken confirmationToken = new ConfirmationToken(appUser);
        assertEquals(appUser, confirmationToken.getUser());
    }

    @Test
    public void testConfirmationTokenBuilder() {
        ConfirmationToken confirmationToken = ConfirmationToken.builder()
                .id(1L)
                .confirmationToken("token")
                .createdDate(null)
                .user(null)
                .build();

        assertEquals(1L, confirmationToken.getId());
        assertEquals("token", confirmationToken.getConfirmationToken());
        assertNull(confirmationToken.getCreatedDate());
        assertNull(confirmationToken.getUser());
    }
}
