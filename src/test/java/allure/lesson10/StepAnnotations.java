package allure.lesson10;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class StepAnnotations {
    @Test
    void testIssueNameInRepository() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsForStepAnnotations steps = new StepsForStepAnnotations();

        steps.openEroshenkoamPageOnGithub();
        steps.gotoTabRepositories();
        steps.gotoRepositoryAllureExample();
        steps.gotoTabIssues();
        steps.verifyIssueName();
    }
}
