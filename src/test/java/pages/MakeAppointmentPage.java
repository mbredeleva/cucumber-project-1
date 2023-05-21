package pages;

import com.codeborne.selenide.SelenideElement;
import myproject.enums.Facility;
import myproject.enums.Program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MakeAppointmentPage extends StartPage {

    SelenideElement section = $(byCssSelector("section[id=\"appointment\"]"));
    SelenideElement facilityDropdown = section.find(byId("combo_facility"));

    SelenideElement radio = section.find(byClassName("col-sm-4"));

    SelenideElement calendar = section.find(byId("txt_visit_date"));

    SelenideElement submitButton = section.find(byId("btn-book-appointment"));

    public MakeAppointmentPage() {
        url = "/#appointment";
        pageTitle = "CURA Healthcare Service";
    }

    public void submitForm() {
        submitButton.click();
    }

    public void setDate(LocalDate date) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(dateTimeFormatter);

        calendar.setValue(formattedDate);
    }

    public void setProgram(Program program) {
        $(byValue(program.value)).click();
               // .selectRadio(program.programName);
    }

    public void setFacility(Facility facility) {
        facilityDropdown.selectOption(facility.cityName);
    }

    public boolean isDisplayed() {
        return section.isDisplayed();
    }

    public boolean atPage() {
        return isDisplayed();
    }
}
