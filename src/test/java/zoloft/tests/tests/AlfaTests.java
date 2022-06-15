package zoloft.tests.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import zoloft.tests.helpers.DriverUtils;

import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class AlfaTests extends TestBase {

    @Test
    @Description("Проверка работы страницы оформления кредитной карты")
    @DisplayName("Карта Web Test")
    void cardsPageTest() {
        step("Открываем сайт 'Альфа-Банка'", () -> {
           mainPage.openPage();
        });

        step("Нажимаем на кнопку 'Стать клиентом' --> 'Карты'", () -> {
            mainPage.clienMenuExpand();
            mainPage.creditCardPageTransfer();
        });

        step("Нажимаем на кнопку 'Получить карту'", () -> {
            creditCardsPage.creditCardFormTransfer();
        });

        step("Проверяем, что мы на верной странице и на верном экране", () -> {
            creditCardsPage.cardsPageCheck();
        });
    }

    @Test
    @Description("Проверка наличия Title на странице")
    @DisplayName("Работоспособность сайта")
    void titleTest() {
        step("Открываем сайт 'Альфа-Банка'", () -> {
            mainPage.openPage();
        });
        step("Проверяем наличие Title", () -> {
            String expectedTitle = "Альфа-Банк - кредитные и дебетовые карты, кредиты наличными, автокредитование, " +
                    "ипотека и другие банковские услуги физическим и юридическим лицам – Альфа-Банк";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Проверка наличия ошибок в консоли")
    @DisplayName("Логи консоли страницы не должны содержать ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем сайт 'Альфа-Банка'", () -> {
            mainPage.openPage();
        });

        step("Логи в консоле не должны иметь 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}