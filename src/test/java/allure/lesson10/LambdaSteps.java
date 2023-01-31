package allure.lesson10;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaSteps {

    @Test
    void testIssueNameInRepository() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу Артёма Ерошенко на GitHub", () -> {
            open("https://github.com/eroshenkoam");
        });

        step("Переход на таб Repositories", () -> {
            $("[data-tab-item=\"repositories\"]").click();
        });

        step("Переход в репо allure-example", () -> {
            $(byText("allure-example")).click();
        });

        step("Переход на таб issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверка имени у issue #81", () -> {
            $("#issue_81_link").shouldHave(text("issue_to_test_allure_report"));
        });

    }
}
