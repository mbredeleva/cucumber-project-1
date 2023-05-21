package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import myproject.SelenideHelper;
import myproject.VisitData;
import myproject.enums.Facility;
import myproject.enums.Program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class HistoryPage extends StartPage {
    SelenideElement section = $(byCssSelector("section[id=\"history\"]"));
    ElementsCollection visits = section.findAll(byCssSelector("div.panel-info"));

    public HistoryPage() {
        url = "/history.php#history";
        pageTitle = "CURA Healthcare Service";
    }

    public boolean atPage() {
        return section.isDisplayed();
    }

    public SelenideElement getFirstVisit() {
        return visits.first();
    }

    public VisitData getFirstVisitData() {
        SelenideElement firstVisit = getFirstVisit();
        String facility = SelenideHelper.getValFromTable(firstVisit, "facility");
        String comment = SelenideHelper.getValFromTable(firstVisit, "comment");
        String hospitalReadmission = SelenideHelper.getValFromTable(firstVisit, "hospital_readmission");
        String program = SelenideHelper.getValFromTable(firstVisit, "program");
        String date = firstVisit.find(byClassName("panel-heading")).getText();

        return new VisitData(
                Facility.findByCityName(facility),
                hospitalReadmission.equals("Yes"),
                Program.findByProgramName(program),
                LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")), //TODO: move formatter to config
                comment);
    }
}
