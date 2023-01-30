package javafaker.lesson9.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCitySelectors {
    public void state(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
    }

    public void city(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
    }
}
