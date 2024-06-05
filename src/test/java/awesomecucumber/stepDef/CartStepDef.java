package awesomecucumber.stepDef;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartStepDef {

    private final CartPage cartPage;

    public CartStepDef(TestContext context) {
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @Then("User should see {int} {product} in the cart")
    public void userShouldSeeProductsInTheCart(int expQty , Product product) {
//        TestNG Assert
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        Assert.assertEquals(cartPage.getProductQuantity(), expQty);

//        Junit Assert
        /*Assert.assertEquals(cartPage.getProductName(), product.getName());
        Assert.assertEquals(cartPage.getProductQuantity(), expQty);*/
    }




}
