package awesomecucumber.api;

import awesomecucumber.constants.MyConstants;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

public class CartApi {

    private Cookies cookies;

    public CartApi(Cookies cookies) {
        this.cookies = cookies;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public Response addToCart(int productId, int productQty){
        Header header = new Header("content-type","application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String,Object> formParams = new HashMap<>();
        formParams.put("product-sku","");
        formParams.put("product_id",productId);
        formParams.put("quantity",productQty);

        Response response = ApiRequest.post(MyConstants.ADD_TO_CART,headers,formParams,cookies);
        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to add product : " +productId+ " to the cart" + ", HTTP Status Code : "
                    +response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;

    }
}
