package pages;

import com.codeborne.selenide.SelenideElement;
import myproject.SelenideHelper;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static myproject.enums.StringConstants.APPOINTMENT_CREATED_MESSAGE;

public class AppointmentConfirmationPage extends StartPage {

    SelenideElement section = $(byCssSelector("section[id=\"summary\"]"));

    public AppointmentConfirmationPage() {
        url = "/appointment.php#summary";
        pageTitle = "CURA Healthcare Service";
    }

    public boolean confirmationMessageShown() {
        return section.find(byCssSelector("h2")).getText().equals(APPOINTMENT_CREATED_MESSAGE);
    }

    public String getFacility() {
        return SelenideHelper.getValFromTable(section, "facility");
    }

    public String getProgram() {
        return SelenideHelper.getValFromTable(section, "program");
    }

    public String getVisitDate() {
        return SelenideHelper.getValFromTable(section, "visit_date");
    }
}
