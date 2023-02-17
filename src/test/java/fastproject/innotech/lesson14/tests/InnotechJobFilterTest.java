package fastproject.innotech.lesson14.tests;

import fastproject.innotech.lesson14.tests.setup.TestBase;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class InnotechJobFilterTest extends TestBase {

    @Test
    @DisplayName("Проверка работы фильтра вакансий - есть хотя бы 1 вакансия")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina Papsueva")
    @Tag("innotech_test")
    void careerFilterHaveVacanciesTest() {

        step("Открываем страницу https://inno.tech/career", () -> {
            innotechMainPageData.openCareerPage();
        });

        step("Клик на кнопку Стать частью команды", () -> {
            $("[href='/vacancies']").click();
        });

        step("Проверяем, что открылась нужная страница по главному заголовку", () -> {
            $(".specialization-card-list__root--8eEt7 h1").shouldHave(text("всегда есть вакансия"));
        });

        step("Выбираем город", () -> {
            $(".select__title--3oxLm").find(byText("Город")).click();
            $$("li").findBy(text("Ростов-на-Дону")).click();
        });

        step("Выбираем направление", () -> {
            $$(".select__title--3oxLm").findBy(text("Специализация")).click();
            $$("li").findBy(text("Тестирование")).click();
        });

        step("Проверяем, что вакансия найдена", () -> {
            $(".vacancy-list__left-block--PNL7D").shouldHave(text("вакансия"));
        });
    }

    @Test
    @DisplayName("Проверка работы фильтра вакансий - вакансий не найдено")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina Papsueva")
    @Tag("innotech_test")
    void careerFilterNoHaveVacanciesTest() {

        step("Открываем страницу https://inno.tech/career", () -> {
            innotechMainPageData.openCareerPage();
        });

        step("Клик на кнопку Стать частью команды", () -> {
            $("[href='/vacancies']").click();
        });

        step("Проверяем, что открылась нужная страница по главному заголовку", () -> {
            $("#app").shouldHave(text("всегда есть вакансия"));
        });

        step("Выбираем город", () -> {
            $(".select__title--3oxLm").find(byText("Город")).click();
            $$("li").findBy(text("Ростов-на-Дону")).click();
        });

        step("Выбираем направление", () -> {
            $$(".select__title--3oxLm").findBy(text("Специализация")).click();
            $$("li").findBy(text("HR")).click();
        });

        step("Проверяем, что вакансий нет", () -> {
            $(".not-found__not-found--20jWT").shouldHave(text("Ничего не найдено"));
        });
    }
}
