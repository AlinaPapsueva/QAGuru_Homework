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

public class InnotechLinkToCareerPageTest extends TestBase {

    @Test
    @DisplayName("Проверка перехода на страницу Карьера")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina Papsueva")
    @Tag("innotech_test")
    void careerLinkTest() {

        step("Открываем сайт https://inno.tech/ru/", () -> {
            innotechMainPageData.openMainPage();
        });

        step("Клик на ссылку Карьера", () -> {
            $("[href='https://inno.tech/career']").click();
        });

        step("Переключаемся на вкладку в браузере Карьера", () -> {
            switchTo().window(1);
        });

        step("Проверяем, что открылась нужная страница по главному заголовку", () -> {
            $("#app").shouldHave(text("Нас уже более 10000 сотрудников"));
        });
    }
}
