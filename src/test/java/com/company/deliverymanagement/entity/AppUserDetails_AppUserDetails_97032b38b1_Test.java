import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class AppUserDetailsTest {

    @Test
    public void testAppUserDetails_withValidAppUser() {
        AppUser appUserMock = mock(AppUser.class);
        when(appUserMock.getName()).thenReturn("John");
        when(appUserMock.getSurname()).thenReturn("Doe");
        when(appUserMock.getUsername()).thenReturn("johndoe");
        when(appUserMock.getPassword()).thenReturn("password123");
        // TODO: Set appropriate date for birthday
        when(appUserMock.getBirthday()).thenReturn(null);
        when(appUserMock.getEmail()).thenReturn("johndoe@example.com");
        when(appUserMock.getPhoneNumber()).thenReturn("1234567890");
        when(appUserMock.getIsEnabled()).thenReturn(true);
        when(appUserMock.getRoles()).thenReturn(null);

        AppUserDetails appUserDetails = new AppUserDetails();
        appUserDetails.setName(appUserMock.getName());
        appUserDetails.setSurname(appUserMock.getSurname());
        appUserDetails.setUsername(appUserMock.getUsername());
        appUserDetails.setPassword(appUserMock.getPassword());
        appUserDetails.setBirthday(appUserMock.getBirthday());
        appUserDetails.setEmail(appUserMock.getEmail());
        appUserDetails.setPhoneNumber(appUserMock.getPhoneNumber());
        appUserDetails.setIsEnabled(appUserMock.getIsEnabled());
        appUserDetails.setRoles(appUserMock.getRoles());

        assertEquals("John", appUserDetails.getName());
        assertEquals("Doe", appUserDetails.getSurname());
        assertEquals("johndoe", appUserDetails.getUsername());
        assertEquals("password123", appUserDetails.getPassword());
        // TODO: Assert for birthday
        assertEquals("johndoe@example.com", appUserDetails.getEmail());
        assertEquals("1234567890", appUserDetails.getPhoneNumber());
        assertEquals(true, appUserDetails.getIsEnabled());
        assertEquals(null, appUserDetails.getRoles());
    }
}
