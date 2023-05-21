package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends StartPage {
    SelenideElement section = $(byCssSelector("section[id=\"login\"]"));
    SelenideElement usernameInput = section.find(byId("txt-username"));
    SelenideElement passwordInput = section.find(byId("txt-password"));
    SelenideElement loginButton = section.find(byId("btn-login"));

    public boolean loginSectionDisplayed() {
        return section.isDisplayed();
    }

    public LoginPage() {
        url = "/profile.php#login";
        pageTitle = "CURA Healthcare Service";
    }
    public boolean atPage() {
        return loginSectionDisplayed();
    }

    public void makeLogin(String login, String password) {
        usernameInput.setValue(login);
        passwordInput.setValue(password);
        loginButton.click();
    }

    public boolean unSuccessLoginHappened(){
        return  (this.errorMessage.isDisplayed() && this.errorMessage.getText().equals(
                "Login failed! Please ensure the username and password are valid.")); //TODO: move to constants
    }
}
