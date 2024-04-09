package endpoints;

import io.restassured.response.Response;

public class ProductsApi extends BasicApi {

    public ProductsApi(String token) {
        super(token);
    }

    public Response getAllProducts() {
        return getBuilderAuth()
                .get(Urls.PRODUCTS_URL);
    }

    public Response getProductById(Integer id) {
        return getBuilderAuth()
                .get(Urls.PRODUCTS_URL + "/{id}", id);
    }
    
}
