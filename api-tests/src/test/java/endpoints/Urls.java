package endpoints;

import org.aeonbits.owner.ConfigFactory;
import utils.ApiProps;

public class Urls {

    public static final String BASE_URL = ConfigFactory.create(ApiProps.class).baseUrl();

    public static final String REGISTER_URL = "/register";
    public static final String LOGIN_URL = "/login";
    public static final String PRODUCTS_URL = "/products";
    public static final String CART_URL = "/cart";
}