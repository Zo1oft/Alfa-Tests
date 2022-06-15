package zoloft.tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditCardsPage {

    //locators
    SelenideElement
    creditCardsHeader = $$("[data-test-id=button").findBy(Condition.text("Получить карту")),
    creditCardsFormHeader = $("[data-widget-name=Heading]");


    //actions
    public void creditCardFormTransfer() {
        creditCardsHeader.click();
    }

    public void cardsPageCheck() {
        creditCardsFormHeader.shouldHave(Condition.text("Заявка на кредитную карту"));
    }
}
