package fastproject.innotech.lesson14.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class InnotechSiteTest extends TestBase {

    @Test
    @DisplayName("Проверка основных элементов на главной странице")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina Papsueva")
    @Tag("innotech_test")
    @Order(1)
    void mainPageTest() {

        step("Открываем сайт https://inno.tech/ru/", () -> {
            innotechMainPageData.openMainPage();
        });

        step("Проверяем, что в меню хедера есть все необходимые кнопки", () -> {
            $(".header-nav").shouldHave(
                    text("Продукты"),
                    text("О компании"),
                    text("Ресурсы"),
                    text("Карьера"));
        });

        step("Проверяем, что в блоке 'Цифровизация по всему миру' есть видео и оно работает", () -> {
            $(".video-play").click();
            sleep(2500);
            $(".video-play").click();
            $(".video-time").shouldHave(text("00:02/00:18"));
        });

        step("Проверяем, что блок 'Трансформируйте свою банковскую миссию в реальные результаты' присутствует", () -> {
            $("[class='section main-product']").$(".section-title").shouldHave(text("ТРАНСФОР\u00ADМИРУЙТЕ СВОЮ БАНКОВСКУЮ МИССИЮ В РЕАЛЬНЫЕ РЕЗУЛЬТАТЫ"));
        });

        step("Проверяем, что блок 'Рекомендуем почитать' присутствует", () -> {
            $("[class='section main-news']").shouldHave(text("Рекомендуем почитать"));
        });

        step("Проверяем, что блок 'Остались вопросы?' присутствует", () -> {
            $("[class='section main-form']").shouldHave(text("ОСТА\u00ADЛИСЬ\n" +
                    "ВОП\u00ADРОСЫ?"));
        });
    }

    @Test
    @DisplayName("Проверка перехода в Личный кабинет без vpn")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina Papsueva")
    @Tag("innotech_test")
    @Order(2)
    void lkWithoutVPNTest() {

        step("Открываем сайт https://inno.tech/ru/", () -> {
            innotechMainPageData.openMainPage();
        });

        step("Клик на ссылку Личный кабинет", () -> {
            $("[href='https://ca.inno.tech']").click();
        });

        switchTo().window(1);

        step("Проверяем, что открылась нужная страница по главному заголовку", () -> {
            $(".popup").shouldHave(text("Включите VPN, чтобы получить доступ"));
        });
    }

    @Test
    @DisplayName("Проверка перехода на страницу Карьера")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina Papsueva")
    @Tag("innotech_test")
    @Order(3)
    void careerLinkTest() {

        step("Открываем сайт https://inno.tech/ru/", () -> {
            innotechMainPageData.openMainPage();
        });

        step("Клик на ссылку Карьера", () -> {
            $("[href='https://inno.tech/career']").click();
        });

        switchTo().window(1);

        step("Проверяем, что открылась нужная страница по главному заголовку", () -> {
            $("#app").shouldHave(text("Нас уже более 10000 сотрудников"));
        });
    }

    @Test
    @DisplayName("Проверка работы фильтра вакансий - есть хотя бы 1 вакансия")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina Papsueva")
    @Tag("innotech_test")
    @Order(4)
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
    @Order(5)
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
