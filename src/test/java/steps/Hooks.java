package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.utilsWeb;

public class Hooks {

    @Before
    public void setup() {
        utilsWeb.getDriver();
    }

    @After
    public void teardown() {
        utilsWeb.quitDriver();
    }

    private WebDriver driver = utilsWeb.getDriver();

    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }

        driver.quit();
    }
}
