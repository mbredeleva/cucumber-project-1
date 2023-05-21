package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BrowserConfig {
    @Before
    public void setBrowser() {
        System.out.println("Config browser");
        //Configuration.screenshots = true;
        Configuration.timeout = 30000;

        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://katalon-demo-cura.herokuapp.com";

    }

    @After
    public void close() {
        Selenide.closeWebDriver();
    }

    @After
    public void scenarioTearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) WebDriverRunner.getWebDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
