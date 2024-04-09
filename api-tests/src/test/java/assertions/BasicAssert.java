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
                .as("Field " + massage + " is not massage in the response")
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
                .as("Field " + field + " is not equal to '%s'", expectedValue)
                .isEqualTo(expectedValue);

        return this;
    }

    public BasicAssert fieldEqual(String fieldPath, int expectedValue) {
        Assertions.assertThat(actual.jsonPath().getInt(fieldPath))
                .as("Field " + fieldPath + " is not equal to '%d'", expectedValue)
                .isEqualTo(expectedValue);

        return this;
    }

    public BasicAssert fieldEqual(String fieldPath, Double expectedValue) {
        Assertions.assertThat(actual.jsonPath().getDouble(fieldPath))
                .as("Field " + fieldPath + " is not equal to '%d'", expectedValue)
                .isEqualTo(expectedValue);

        return this;
    }

    public void isGreaterThanOrEqualTo(int num) {
        Assertions.assertThat(actual.jsonPath().getList("$").size()).isGreaterThanOrEqualTo(num);
    }
}
