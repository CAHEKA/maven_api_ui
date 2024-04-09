package endpoints;

import dto.request.Cred;
import io.restassured.response.Response;
import utils.RestApiBuilder;


public class AuthApi {

    public static Response registerNewUser(String username, String userPassword) {
        return new RestApiBuilder(Urls.BASE_URL).build()
                .body(new Cred(username, userPassword))
                .post(Urls.REGISTER_URL);
    }

    public static Response loginUser(String username, String userPassword) {
        return new RestApiBuilder(Urls.BASE_URL).build()
                .body(new Cred(username, userPassword))
                .post(Urls.LOGIN_URL);
    }
}