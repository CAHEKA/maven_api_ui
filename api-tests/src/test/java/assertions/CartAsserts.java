package assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;

public class CartAsserts extends AbstractAssert<CartAsserts, Response> {
    public CartAsserts(Response actual) {
        super(actual, CartAsserts.class);
    }

    public static CartAsserts assertThat(Response actual) {
        return new CartAsserts(actual);
    }
    
    @Step("check massage {massage}")
    public CartAsserts checkMassage(String massage) {
        BasicAssert.assertThat(actual).containsMassageInResponse(massage);

        return this;
    }
}
