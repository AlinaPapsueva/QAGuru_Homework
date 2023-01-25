package junit5.lesson7;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SaucedemoParameterizedTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    //Этот тест проведет 4 проверки: 3 пройдут, 1 будет провалена
    //Из результатов, записанных в папке reports, мы увидим, что будет провален тест со строкой 2
    //которая соответствует locked_out_user в файле csv

    @CsvFileSource(resources = "/saucedemo_testdata.csv")
    @ParameterizedTest(name = "Все пользователи могут залогиниться на сайт, кроме locked_out_user")
    @Tags({@Tag("BLOCKER"), @Tag("AUTH")})
    void loginUsersTestWithCsvFile(String userName, String password) {
        open("https://www.saucedemo.com/");
        $("#user-name").setValue(userName);
        $("#password").setValue(password);
        $("#login-button").click();
        $(".header_secondary_container .title").shouldHave(text("Products"));
    }

    @CsvSource({
            "standard_user, secret_sauce",
            "locked_out_user, secret_sauce",
            "problem_user, secret_sauce",
            "performance_glitch_user, secret_sauce"
    })
    @ParameterizedTest(name = "Все пользователи могут залогиниться на сайт, кроме locked_out_user")
    @Tags({@Tag("BLOCKER"), @Tag("AUTH")})
    void loginUsersTestWithCsvSource(String userName, String password) {
        open("https://www.saucedemo.com/");
        $("#user-name").setValue(userName);
        $("#password").setValue(password);
        $("#login-button").click();
        $(".header_secondary_container .title").shouldHave(text("Products"));
    }

    static Stream<Arguments> selenideLocaleDataProvider() {
        return Stream.of(
                Arguments.of("standard_user", "secret_sauce"),
                Arguments.of("locked_out_user", "secret_sauce"),
                Arguments.of("problem_user", "secret_sauce"),
                Arguments.of("performance_glitch_user", "secret_sauce")
        );
    }

    @MethodSource("selenideLocaleDataProvider")
    @ParameterizedTest(name = "Все пользователи могут залогиниться на сайт, кроме locked_out_user")
    @Tags({@Tag("BLOCKER"), @Tag("AUTH")})
    void loginUsersTestWithMethodSource(String userName, String password) {
        open("https://www.saucedemo.com/");
        $("#user-name").setValue(userName);
        $("#password").setValue(password);
        $("#login-button").click();
        $(".header_secondary_container .title").shouldHave(text("Products"));
    }
}
