import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApi {
    @Test
    public void apiTest() {
        assertEquals(1, 1);
    }
    
    @Test
    @Tag("smoke")
    public void apiTagTest() {
        assertEquals(1, 1);
    }
}
