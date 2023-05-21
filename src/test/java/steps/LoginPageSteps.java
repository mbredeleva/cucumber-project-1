package steps;

import pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginPageSteps {

    private final LoginPage loginPage;

    public LoginPageSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("^the user opens login page$")
    public void user_opens_login_page() {
        loginPage.openPage();
        assert loginPage.atPage();
    }

    @When("the user types incorrect credentials")
    public void user_types_incorrect_credentials() {
        loginPage.makeLogin("lalala", "lalala");
    }

    @When("the user types correct credentials")
    public void user_types_correct_credentials() {
        loginPage.makeLogin("John Doe", "ThisIsNotAPassword");
    }

    @Then("the user sees incorrect credentials error message")
    public void user_sees_incorrect_credentials_message() {
        loginPage.unSuccessLoginHappened();
    }

}
