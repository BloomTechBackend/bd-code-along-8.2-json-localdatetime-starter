import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class Step1Test {

    @Test
    public void testBookCSVAvailability() {
        URL u = App.class.getResource("books.csv");
        assertNotNull(u);
    }
}
