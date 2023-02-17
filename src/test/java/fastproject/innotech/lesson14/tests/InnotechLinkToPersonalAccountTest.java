package fastproject.innotech.lesson14.tests;

import fastproject.innotech.lesson14.tests.setup.TestBase;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class InnotechLinkToPersonalAccountTest extends TestBase {


    @Test
    @DisplayName("Проверка перехода в Личный кабинет без vpn")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina Papsueva")
    @Tag("innotech_test")
    void lkWithoutVPNTest() {

        step("Открываем сайт https://inno.tech/ru/", () -> {
            innotechMainPageData.openMainPage();
        });

        step("Клик на ссылку Личный кабинет", () -> {
            $("[href='https://ca.inno.tech']").click();
        });

        step("Переключаемся на вкладку в браузере Личный кабинет", () -> {
            switchTo().window(1);
        });


        step("Проверяем, что открылась нужная страница по главному заголовку", () -> {
            $(".popup").shouldHave(text("Включите VPN, чтобы получить доступ"));
        });
    }
}
