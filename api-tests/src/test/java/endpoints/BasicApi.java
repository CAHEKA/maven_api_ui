package endpoints;

import io.restassured.specification.RequestSpecification;
import utils.RestApiBuilder;

public class BasicApi {
    private final String token;

    public BasicApi(String token) {
        this.token = token;
    }

    public RequestSpecification getBuilderAuth() {
        return new RestApiBuilder(Urls.BASE_URL)
                .withAuth(token)
                .build();
    }
    
}