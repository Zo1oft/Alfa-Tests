package zoloft.tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    //locators
    SelenideElement
            clientButton = $("[data-test-id=popover-target]"),
            creditCardsPageButton = $$("div[class=C1B_-k]").findBy(Condition.text("Кредитка на год без %"));


    //actions
    public MainPage openPage() {
        open("https://alfabank.ru/");
        return this;
    }

    public void clienMenuExpand() {
      clientButton.click();
    }

    public void creditCardPageTransfer() {
      creditCardsPageButton.click();
    }
}
