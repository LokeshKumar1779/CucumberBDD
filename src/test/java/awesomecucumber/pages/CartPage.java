package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

    @FindBy(css = "td[data-title='Product'] a") private WebElement productName;
    @FindBy(css = "input[title='Qty']") private WebElement productQuantity;

    @FindBy(css = ".checkout-button") private WebElement checkOutBtn;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        wait.until(ExpectedConditions.visibilityOf(productName));
        return productName.getText();

    }

    public int getProductQuantity(){
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productQuantity)).getAttribute("value"));
    }

    public void checkOut(){
        wait.until(ExpectedConditions.visibilityOf(checkOutBtn)).click();
    }
}
