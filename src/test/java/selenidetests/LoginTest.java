package selenidetests;

import pages.LoginPage;
import pages.StartPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseSelenideTest {

    @Test
    public void unSuccessLoginTest() {
        StartPage startPage = new StartPage();
        startPage.openPage();
        startPage.clickMakeAppointmentButton();

        LoginPage loginPage = new LoginPage();
        assertThat(loginPage.atPage());
        loginPage.makeLogin("lalala", "lalala");
        assertThat(loginPage.unSuccessLoginHappened());
    }
}
