package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends StartPage {
    SelenideElement section = $(byCssSelector("section[id=\"profile\"]"));
    String messageText = section.find(byCssSelector("p.lead")).getText();

    public ProfilePage() {
        url = "/profile.php#profile";
        pageTitle = "CURA Healthcare Service";
    }

    public boolean atPage() {
        return section.isDisplayed();
    }

    public String getMessageText() {
        return this.messageText;
    }

}
