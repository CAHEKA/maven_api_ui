
import io.restassured.RestAssured;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiTest {
    @Test
    public void uiTest() {
        assertEquals(1, 1);
    }
    
    @Test
    public void restTest() {
        RestAssured.when().
                get("https://ya.ru/").
                then().
                statusCode(200);
    }
    
    @Test
    @Tag("smoke")
    public void uiTagTest() {
        assertEquals(1, 1);
    }
}
