package awesomecucumber.stepDef;

import awesomecucumber.api.CartApi;
import awesomecucumber.constants.MyConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.PageFactoryManager;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.*;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class StoreStepDef {

    private final StorePage storePage;
    private TestContext context;
    public StoreStepDef(TestContext context) {
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }


    @Step("User at store page")
    @Given("User is at store page")
    public void userIsAtStorePage() {
        storePage.load(MyConstants.STORE);
    }

    @Step("User adds product to cart")
    @When("User adds a {product} to cart")
    public void userAddsAToCart(Product product) {
        storePage.addToCart(product.getName());
    }

    @Step("A product is available in the cart")
    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {

        //        storePage.addToCart("Blue Shoes");
        storePage.load(MyConstants.STORE);
        CartApi cartApi = new CartApi(new io.restassured.http.Cookies());
        cartApi.addToCart(1215, 1);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);

    }


}
