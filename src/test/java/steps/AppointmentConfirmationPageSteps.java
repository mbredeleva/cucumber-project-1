package steps;

import myproject.enums.Facility;
import myproject.enums.Program;
import pages.AppointmentConfirmationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class AppointmentConfirmationPageSteps {
    private final AppointmentConfirmationPage appointmentConfirmationPage;

    public AppointmentConfirmationPageSteps(AppointmentConfirmationPage appointmentConfirmationPage) {
        this.appointmentConfirmationPage = appointmentConfirmationPage;
    }

    @Then("the user sees appointment created message")
    public void theUserSeesAppointmentCreatedMessage() {
        assertThat(appointmentConfirmationPage.confirmationMessageShown()).isTrue();
    }

    @And("appointment city is Seoul")
    public void appointmentCityIsSeoul() {
        String city = appointmentConfirmationPage.getFacility();
        assertThat(city).isEqualTo(Facility.SEOUL.cityName);
    }

    @And("program is medicaid")
    public void programIsMedicaid() {
        String program = appointmentConfirmationPage.getProgram();
        assertThat(program).isEqualTo(Program.MEDICAID.value);
    }

    @And("visit date is tomorrow")
    public void visitDateIsTomorrow() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String expected = LocalDate.now().plusDays(1).format(dateTimeFormatter);
        assertThat(appointmentConfirmationPage.getVisitDate()).isEqualTo(expected);
    }
}
