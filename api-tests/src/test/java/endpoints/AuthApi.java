package endpoints;

import dto.request.Cred;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utils.RestApiBuilder;


public class AuthApi {

    @Step("register user {username}")
    public static Response registerNewUser(String username, String userPassword) {
        return new RestApiBuilder(Urls.BASE_URL).build()
                .body(new Cred(username, userPassword))
                .post(Urls.REGISTER_URL);
    }

    @Step("login user {username}")
    public static Response loginUser(String username, String userPassword) {
        return new RestApiBuilder(Urls.BASE_URL).build()
                .body(new Cred(username, userPassword))
                .post(Urls.LOGIN_URL);
    }
}