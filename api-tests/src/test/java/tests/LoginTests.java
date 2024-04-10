package tests;

import assertions.CartAsserts;
import endpoints.AuthApi;
import endpoints.CartApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LoginTests {
    
    @Test
    @Tag("regression")
    void invalidUserNameTest() {
        Response response = AuthApi
                .loginUser("______000000", "testPassword");
        CartAsserts.assertThat(response)
                .checkMassage("Invalid credentials");
    }
    
}
