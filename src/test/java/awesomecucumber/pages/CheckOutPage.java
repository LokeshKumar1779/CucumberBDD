package awesomecucumber.pages;

import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.domainobjects.PersonalDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {

    @FindBy(css = "#billing_first_name")
    private WebElement firstNameFld;
    @FindBy(css = "#billing_last_name")
    private WebElement lastNameFld;
    @FindBy(css = "#billing_address_1")
    private WebElement addressLine1Fld;
    @FindBy(css = "#billing_city")
    private WebElement billingCityFld;
    @FindBy(css = "#billing_state")
    private WebElement billingStateDD;
    @FindBy(css = "#billing_postcode")
    private WebElement zipCodeFld;
    @FindBy(css = "#billing_email")
    private WebElement emailFld;

    @FindBy(css = "#place_order")
    private WebElement placeOrderBtn;

    @FindBy(css = ".woocommerce-notice")
    private WebElement orderSuccessText;

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameFld));
        firstNameFld.clear();
        firstNameFld.sendKeys(firstName);
        return this;
    }

    public CheckOutPage enterLastName(String lastName) {
        lastNameFld.clear();
        lastNameFld.sendKeys(lastName);
        return this;
    }

    public CheckOutPage enterAddressLine1(String addressLine1) {
        addressLine1Fld.clear();
        addressLine1Fld.sendKeys(addressLine1);
        return this;
    }


    public CheckOutPage enterCity(String city) {
        billingCityFld.clear();
        billingCityFld.sendKeys(city);
        return this;
    }

    public CheckOutPage selectState(String state) {
        Select select = new Select(billingStateDD);
        select.selectByVisibleText(state);
        return this;
    }

    public CheckOutPage enterZipCode(String zipCode) {
        zipCodeFld.clear();
        zipCodeFld.sendKeys(zipCode);
        return this;
    }

    public CheckOutPage enterEmail(String email) {
        emailFld.clear();
        emailFld.sendKeys(email);
        return this;
    }

    public CheckOutPage setPersonalDetails(PersonalDetails personalDetails) {
        enterFirstName(personalDetails.getFirstname()).
                enterLastName(personalDetails.getLastname()).
                enterEmail(personalDetails.getEmail());
        return this;
    }

    public CheckOutPage setBillingAddress(BillingDetails billingDetails) {
        enterAddressLine1(billingDetails.getAddressLine1()).
                enterCity(billingDetails.getCity()).
                selectState(billingDetails.getState()).
                enterZipCode(billingDetails.getZipcode());
        return this;
    }

    public CheckOutPage placeOrder() {
        placeOrderBtn.click();
        return this;
    }

    public String getNotice() {
        wait.until(ExpectedConditions.visibilityOf(orderSuccessText));
        return orderSuccessText.getText();
    }


}
