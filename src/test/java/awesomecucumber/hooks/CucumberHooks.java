package awesomecucumber.hooks;

import awesomecucumber.constants.BrowserType;
import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    private final TestContext context;
    private WebDriver driver;

    public CucumberHooks(TestContext context){
        this.context = context;

    }
    @Before
    public void before(Scenario scenario){
//        context.scenarioName = scenario.getName();
//        System.out.println("HOOKS CLASS - DI SCENARIO NAME : " +context.getScenarioName());
//        System.out.println("THREAD ID : " +Thread.currentThread().getId() +
//                " Scenario Name : " + scenario.getName());
        String browser = System.getProperty("browser") == null ? String.valueOf(BrowserType.CHROME) : System.getProperty("browser");
        driver = DriverFactory.initializeDriver(browser);
        context.driver = driver;

    }

    @After
    public void after(Scenario scenario){
        driver.quit();
    }
}
