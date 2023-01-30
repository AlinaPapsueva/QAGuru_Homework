package javafaker.lesson9.tests;

import com.codeborne.selenide.Configuration;
import javafaker.lesson9.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

// здесь лежат предустановки для Хром-драйвера
public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }
}
