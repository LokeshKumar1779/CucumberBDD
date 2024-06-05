package awesomecucumber.stepDef;

import awesomecucumber.constants.MyConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.domainobjects.PersonalDetails;
import awesomecucumber.pages.PageFactoryManager;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CustomerStepDef {
    private TestContext context;

    public CustomerStepDef(TestContext context) {
        this.context = context;

    }

    @And("My billing details are")
    public void MyBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }

    @Given("As a guest customer")
    public void asAGuestCustomer(PersonalDetails personalDetails) {
        context.personalDetails = personalDetails;
    }


}
