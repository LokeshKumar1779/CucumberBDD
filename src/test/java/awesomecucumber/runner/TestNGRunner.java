package awesomecucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;


@CucumberOptions(
        plugin = {"html:target/reports/cucumber.html","pretty:io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        snippets = CAMELCASE,
//        dryRun = true,
//        monochrome = true,
        tags = "@Smoke",
        glue = {"awesomecucumber"},
        features = {"src/test/resources/awesomecucumber"}
//        publish = true

)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
