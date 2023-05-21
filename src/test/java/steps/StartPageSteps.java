package steps;

import pages.StartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StartPageSteps {
    private final StartPage startPage;

    public StartPageSteps(StartPage startPage) {
        this.startPage = startPage;
    }

    @When("the user clicks side menu button")
    public void theUserClicksSideMenuButton() {
        startPage.clickSideMenuButton();
    }

    @And("the user clicks history")
    public void theUserClicksHistory() {
        startPage.openHistory();
    }

    @And("the user clicks profile")
    public void theUserClicksProfile() { startPage.openProfile(); }
}
