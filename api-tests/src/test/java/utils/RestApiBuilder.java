package utils;

import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestApiBuilder {

    private final RequestSpecification requestSpecification;

    public RestApiBuilder(String baseUrl) {
        requestSpecification = given().baseUri(baseUrl)
                .config(RestAssuredConfig.config()
                        .httpClient(HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", 5000)))
                .contentType("application/json")
                .relaxedHTTPSValidation();
    }
    
    public RequestSpecification build() {
        return requestSpecification;
    }

    public RestApiBuilder withAuth(String token) {
        requestSpecification.header("Authorization", "Bearer " + token);
        requestSpecification.filters(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter());
        return this;
    }
    
}
