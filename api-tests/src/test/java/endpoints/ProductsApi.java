package endpoints;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class ProductsApi extends BasicApi {

    public ProductsApi(String token) {
        super(token);
    }

    @Step("get all products")
    public Response getAllProducts() {
        return getBuilderAuth()
                .get(Urls.PRODUCTS_URL);
    }

    @Step("get product by id {id}")
    public Response getProductById(Integer id) {
        return getBuilderAuth()
                .get(Urls.PRODUCTS_URL + "/{id}", id);
    }
    
}
