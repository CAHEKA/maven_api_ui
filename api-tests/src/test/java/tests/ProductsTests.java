package tests;

import assertions.ProductAsserts;
import endpoints.AuthApi;
import endpoints.ProductsApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductsTests {
    ProductsApi productsApi;

    @BeforeEach
    void authenticateUser() {
        String authToken = AuthApi
                .loginUser("testUsername", "testPassword")
                .jsonPath()
                .getString("access_token");
        productsApi = new ProductsApi(authToken);
    }

    @Test
    void verifyProductTest() {
        Response response = productsApi.getProductById(1);
        ProductAsserts.assertThat(response)
                .verifyProductResponse(
                        "Electronics",
                        10.0,
                        1,
                        "HP Pavilion Laptop",
                        10.99);
    }

    @Test
    void isGreaterThanOrEqualProductsTest() {
        Response response = productsApi.getAllProducts();
        ProductAsserts.assertThat(response)
                .isGreaterThanOrEqualTo(10);
    }


}
