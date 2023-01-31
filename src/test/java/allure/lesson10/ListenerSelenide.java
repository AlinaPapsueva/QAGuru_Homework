package allure.lesson10;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ListenerSelenide {

    @Test
    void testIssueNameInRepository() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/eroshenkoam");
        $("[data-tab-item=\"repositories\"]").click();
        $(byText("allure-example")).click();
        $("#issues-tab").click();
        $("#issue_81_link").shouldHave(text("issue_to_test_allure_report"));
    }
}
