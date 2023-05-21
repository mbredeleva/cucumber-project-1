package steps;

import pages.ProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import static myproject.enums.StringConstants.UNDER_CONSTRUCTION_MESSAGE;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfilePageSteps {
    private final ProfilePage profilePage;

    public ProfilePageSteps(ProfilePage profilePage) {
        this.profilePage = profilePage;
    }

    @Then("the user sees profile page")
    public void theUserSeesProfilePage() {
        profilePage.atPage();
    }

    @And("the user sees under construction message")
    public void theUserSeesUnderConstructionMessage() {
        assertThat(profilePage.getMessageText()).isEqualTo(UNDER_CONSTRUCTION_MESSAGE);
    }
}
