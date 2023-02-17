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

public class InnotechMainPageTest extends TestBase {

    @Test
    @DisplayName("Проверка основных элементов на главной странице")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina Papsueva")
    @Tag("innotech_test")
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
}
