package pages;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public abstract class BasePage {
    static String pageTitle;
    static String url;

    SelenideElement sideMenuButton = $(byId("menu-toggle"));
    SelenideElement makeAppointmentButton = $(byId("btn-make-appointment"));
    SelenideElement errorMessage = $(byClassName("text-danger"));

    SelenideElement sideMenu = $(byId("sidebar-wrapper"));
    SelenideElement historyLink = sideMenu.find(byLinkText("History"));
    SelenideElement profileLink = sideMenu.find(byLinkText("Profile"));

    public boolean atPage() {
        return (title().equals(pageTitle));
    }
    public void openPage() {
        open(url);
        assert atPage();
    }

    public void openProfile() {profileLink.click();}
    public void openHistory() {historyLink.click();}
    public void clickMakeAppointmentButton(){
        makeAppointmentButton.click();
    }
    public void clickSideMenuButton() { sideMenuButton.click(); }

    //history.php#history
    //sidebar-wrapper

}
