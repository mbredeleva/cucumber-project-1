package selenidetests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;

public class BaseSelenideTest {
    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://katalon-demo-cura.herokuapp.com";
    }
}
