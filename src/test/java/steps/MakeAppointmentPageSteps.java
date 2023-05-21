package steps;

import myproject.enums.Facility;
import myproject.enums.Program;
import pages.MakeAppointmentPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import java.time.LocalDateTime;

public class MakeAppointmentPageSteps {
    private final MakeAppointmentPage makeAppointmentPage;

    public MakeAppointmentPageSteps(MakeAppointmentPage makeAppointmentPage) {
        this.makeAppointmentPage = makeAppointmentPage;
    }

    @Then("the user is logged")
    public void userIsLogged() {
        assert makeAppointmentPage.atPage();
    }

    @When("the user selects Seoul in facility selector")
    public void theUserSelectsSeoulInFacilitySelector() {
        makeAppointmentPage.setFacility(Facility.SEOUL);
    }

    @And("the user selects medicaid radio button")
    public void theUserSelectsMedicaidRadioButton() {
        makeAppointmentPage.setProgram(Program.MEDICAID);
    }

    @And("the user selects tomorrow visit date")
    public void theUserSelectsTomorrowVisitDate() {
        LocalDateTime dt = LocalDateTime.now();
        makeAppointmentPage.setDate(dt.plusDays(1).toLocalDate());
    }

    @And("the user clicks submit button")
    public void theUserClicksSubmitButton() {
        makeAppointmentPage.submitForm();
    }

}
