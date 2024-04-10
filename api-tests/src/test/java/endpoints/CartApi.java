package endpoints;

import dto.request.Card;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class CartApi extends BasicApi {
    
    public CartApi(String token) {
        super(token);
    }

    @Step("add products id {productId} quantity {quantity}")
    public Response addProductsToCart(Integer productId, Integer quantity) {
        return getBuilderAuth()
                .body(new Card(productId, quantity))
                .post(Urls.CART_URL);
    }
}
