package assertions;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;

public class ProductAsserts extends AbstractAssert<ProductAsserts, Response> {

    public ProductAsserts(Response actual) {
        super(actual, ProductAsserts.class);
    }

    public static ProductAsserts assertThat(Response actual) {
        return new ProductAsserts(actual);
    }

    public ProductAsserts verifyProductResponse(String category, Double discount, int id, String name, Double price) {
        BasicAssert.assertThat(actual)
                .statusCodeEqual(200)
                .fieldEqual("category", category)
                .fieldEqual("discount", discount)
                .fieldEqual("id", id)
                .fieldEqual("name", name)
                .fieldEqual("price", price);

        return this;
    }

    public ProductAsserts isGreaterThanOrEqualTo(Integer num) {
        BasicAssert.assertThat(actual).isGreaterThanOrEqualTo(num);
        
        return this;
    }
}