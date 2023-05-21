package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import myproject.VisitData;
import myproject.enums.Facility;
import myproject.enums.Program;
import pages.HistoryPage;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class HistoryPageSteps {
    private final HistoryPage historyPage;

    public HistoryPageSteps(HistoryPage historyPage) {
        this.historyPage = historyPage;
    }

    @Then("the user sees history page")
    public void theUserSeesHistoryPage() {
        historyPage.atPage();
    }

    @And("displayed facility is Seoul")
    public void facilityIsSeoul() {
        VisitData data = historyPage.getFirstVisitData();
        assertThat(data.getFacility()).isEqualTo(Facility.SEOUL);
    }

    @And("displayed apply for hospital readmission is false")
    public void applyForHospitalReadmissionIsFalse() {
        VisitData data = historyPage.getFirstVisitData();
        assertThat(data.isHospitalReadmission()).isFalse();
    }

    @And("displayed program is medicaid")
    public void displayedProgramIsMedicaid() {
        VisitData data = historyPage.getFirstVisitData();
        assertThat(data.getProgram()).isEqualTo(Program.MEDICAID);
    }

    @And("displayed comment is empty")
    public void displayedCommentIsEmpty() {
        VisitData data = historyPage.getFirstVisitData();
        assertThat(data.getComment()).isEqualTo("");
    }

    @And("displayed date is tomorrow")
    public void displayedDateIsTomorrow() {
        VisitData data = historyPage.getFirstVisitData();
        assertThat(data.getDate()).isEqualTo(LocalDate.now().plusDays(1));
    }

}
