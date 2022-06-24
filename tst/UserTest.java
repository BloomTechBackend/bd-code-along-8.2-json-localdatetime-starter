import models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void testValidPassword() {
        String password = "A_b_c_1_2_3";
        User user = new User("test");
        assertTrue(user.validateAndSet(password));
        assertEquals(password, user.getPassword());;
    }

    @Test
    void testInvalidPassword() {
        String password = "abc123";
        User user = new User("test");
        assertFalse(user.validateAndSet(password));
        assertNull(user.getPassword());;
    }
}
