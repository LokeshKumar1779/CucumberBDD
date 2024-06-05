package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    public static CartPage cartPage;
    public static StorePage storePage;
    public static CheckOutPage checkOutPage;

    public static CartPage getCartPage(WebDriver driver) {
        return cartPage == null ? new CartPage(driver) : cartPage;
    }

    public static StorePage getStorePage(WebDriver driver) {
        return storePage == null ? new StorePage(driver) : storePage;
    }

    public static CheckOutPage getCheckOutPage(WebDriver driver) {
        return checkOutPage == null ? new CheckOutPage(driver) : checkOutPage;
    }
}
