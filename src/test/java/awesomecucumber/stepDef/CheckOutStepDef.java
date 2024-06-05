package awesomecucumber.stepDef;

import awesomecucumber.constants.MyConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.pages.CheckOutPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckOutStepDef {
    private final CheckOutPage checkOutPage;
    private TestContext context;


    public CheckOutStepDef(TestContext context) {
        this.context = context;
        checkOutPage = PageFactoryManager.getCheckOutPage(context.driver);
    }
    @When("I provide personal details")
    public void iProvidePersonalDetails() {
        checkOutPage.setPersonalDetails(context.personalDetails);
    }
    @And("I provide billing details")
    public void iProvideBillingDetails() {
//        System.out.println("Billing Details : " +billingDetails.getAddressLine1());
        checkOutPage.setBillingAddress(context.billingDetails);
    }
    @And("I place an order")
    public void iPlaceAnOrder() {
        checkOutPage.placeOrder();
    }
    @Then("order should be placed successfully")
    public void orderShouldBePlacedSuccessfully() {
//        Assert.assertEquals(checkOutPage.getNotice(), "Thank you. Your order has been received.");
        Assert.assertEquals(checkOutPage.getNotice(), "Thank you. Your order has been received.");
    }

    @And("I am on checkout page")
    public void iAmOnCheckoutPage() {
//        cartPage.checkOut();
        checkOutPage.load(MyConstants.CHECKOUT);
    }
}
