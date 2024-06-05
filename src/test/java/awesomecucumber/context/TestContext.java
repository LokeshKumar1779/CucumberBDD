package awesomecucumber.context;

import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.domainobjects.Cookies;
import awesomecucumber.domainobjects.PersonalDetails;
import org.openqa.selenium.WebDriver;

public class TestContext {
    public WebDriver driver;
    public PersonalDetails personalDetails;
    public BillingDetails billingDetails;
    public Cookies cookies;

    public TestContext(){
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
    }
}
