package fastproject.innotech.lesson14.tests.setup;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import fastproject.innotech.lesson14.tests.config.WebDriverProvider;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import systempropertyforjenkins.lesson12.tests.Attach;

public class TestBase {
    public InnotechMainPageData innotechMainPageData = new InnotechMainPageData();

    @BeforeAll
    static void setUp() {
        WebDriverProvider provider = new WebDriverProvider();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @AfterEach
    void closeWindow() {
        Selenide.closeWindow();
    }
}
