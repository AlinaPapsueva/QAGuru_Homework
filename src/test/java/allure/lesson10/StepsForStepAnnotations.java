package allure.lesson10;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsForStepAnnotations {

    @Step("Открываем страницу Артёма Ерошенко на GitHub")
    public void openEroshenkoamPageOnGithub() {
        open("https://github.com/eroshenkoam");
    }

    @Step("Переход на таб Repositories")
    public void gotoTabRepositories() {
        $("[data-tab-item=\"repositories\"]").click();
    }

    @Step("Переход в репо allure-example")
    public void gotoRepositoryAllureExample() {
        $(byText("allure-example")).click();
    }

    @Step("Переход на таб issues")
    public void gotoTabIssues() {
        $("#issues-tab").click();
    }

    @Step("Проверка имени у issue #81")
    public void verifyIssueName() {
        $("#issue_81_link").shouldHave(text("issue_to_test_allure_report"));
    }
}
