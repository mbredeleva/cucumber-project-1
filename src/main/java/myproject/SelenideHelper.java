package myproject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;

public class SelenideHelper {

    public static String getValFromTable(SelenideElement parentElement, String key) {
        return parentElement.find(byCssSelector
                ("label[for=\""+ key + "\"]")).parent().sibling(0).getText();

    }
}
