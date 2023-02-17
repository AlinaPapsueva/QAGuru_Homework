package fastproject.innotech.lesson14.tests.setup;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class InnotechMainPageData {

    private final String TITLE_TEXT = "Будущее цифрового банкинга с нами";

    public InnotechMainPageData openMainPage() {
        open("https://inno.tech/ru/");
        $(".main-screen__title").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public InnotechMainPageData openCareerPage() {
        open("https://inno.tech/career");

        return this;
    }
}
