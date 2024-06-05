package awesomecucumber.factory;

import awesomecucumber.constants.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {



//    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver initializeDriver(String browser){
        WebDriver driver = switch (BrowserType.valueOf(browser)) {
            case CHROME -> new ChromeDriver();
            case SAFARI -> new SafariDriver();
            default -> throw new RuntimeException("INVALID BROWSER : " + browser);
        };
        driver.manage().window().maximize();
//        DriverFactory.driver.set(driver);
        return driver;
    }
/*    public static WebDriver getDriver(){
        return driver.get();
    }*/


}
