package tests;

import assertions.CartAsserts;
import assertions.ProductAsserts;
import endpoints.AuthApi;
import endpoints.CartApi;
import endpoints.ProductsApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CartTests {
    CartApi cartApi;

    @BeforeEach
    void authenticateUser() {
        String authToken = AuthApi
                .loginUser("testUsername", "testPassword")
                .jsonPath()
                .getString("access_token");
        cartApi = new CartApi(authToken);
    }
    
    @Tag("smoke")
    @Test
    void addProductsToCartTest() {
        Response response = cartApi.addProductsToCart(1,2);
        CartAsserts.assertThat(response)
                .checkMassage("Product added to cart successfully");
    }

}
