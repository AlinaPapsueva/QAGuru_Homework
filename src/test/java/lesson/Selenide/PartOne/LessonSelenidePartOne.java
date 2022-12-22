package lesson.selenide.partone;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LessonSelenidePartOne {

    @Test
    void exampleCodeForeJUnit5shouldBeInSoftAssertions () {

        //открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        //раскрыть список Pages
        $(".js-wiki-more-pages-link").click();
        //проверка: в списке Pages есть страница SoftAssertions
        $$(".wiki-more-pages").get(1).shouldHave(text("SoftAssertion"));
        //открыть страницу SoftAssertions
        $$(".wiki-more-pages").get(1).click();
        //проверка: внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
