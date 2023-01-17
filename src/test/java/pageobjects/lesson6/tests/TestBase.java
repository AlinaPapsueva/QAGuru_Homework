package pageobjects.lesson6.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pageobjects.lesson6.pages.RegistrationPage;

// здесь лежат предустановки для Хром-драйвера
public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }
}
