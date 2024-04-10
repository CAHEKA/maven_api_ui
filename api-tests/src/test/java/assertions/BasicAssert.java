package assertions;

import dto.response.Мessage;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class BasicAssert extends AbstractAssert<BasicAssert, Response> {

    public BasicAssert(Response actual) {
        super(actual, BasicAssert.class);
    }

    public static BasicAssert assertThat(Response actual) {
        return new BasicAssert(actual);
    }

    public BasicAssert statusCodeEqual(int expectedStatusCode) {
        Assertions.assertThat(actual.getStatusCode())
                .as("Response code is not equal to " + expectedStatusCode)
                .isEqualTo(expectedStatusCode);

        return this;
    }

    public BasicAssert containsMassageInResponse(String massage) {
        Assertions.assertThat(actual.then().extract().as(Мessage.class).getMessage())
                .as(massage + " is not massage in the response")
                .isEqualTo(massage);

        return this;
    }

    public BasicAssert containsFieldInResponse(String fieldPath) {
        Assertions.assertThat(actual.jsonPath().getString(fieldPath))
                .as("Field " + fieldPath + " is not found in the response body")
                .isNotNull();

        return this;
    }

    public BasicAssert fieldEqual(String field, String expectedValue) {
        Assertions.assertThat(actual.jsonPath().getString(field))
                .as("Field '%s' is not equal to '%s'" , field, expectedValue)
                .isEqualTo(expectedValue);

        return this;
    }

    public BasicAssert fieldEqual(String field, int expectedValue) {
        Assertions.assertThat(actual.jsonPath().getInt(field))
                .as("Field '%s' is not equal to '%d'", field, expectedValue)
                .isEqualTo(expectedValue);

        return this;
    }

    public BasicAssert fieldEqual(String field, Double expectedValue) {
        Assertions.assertThat(actual.jsonPath().getDouble(field))
                .as("Field '%s' is not equal to '%d'", field, expectedValue)
                .isEqualTo(expectedValue);

        return this;
    }

    public BasicAssert isGreaterThanOrEqualTo(int num) {
        Assertions.assertThat(actual.jsonPath().getList("$").size())
                .as("")
                .isGreaterThanOrEqualTo(num);

        return this;
    }
}
