package endpoints;

import dto.Product;
import dto.request.Card;
import io.restassured.response.Response;

public class CartApi extends BasicApi {
    
    public CartApi(String token) {
        super(token);
    }
    
    public Response addProductsToCart(Integer productId, Integer quantity) {
        return getBuilderAuth()
                .body(new Card(productId, quantity))
                .post(Urls.CART_URL);
    }
}
