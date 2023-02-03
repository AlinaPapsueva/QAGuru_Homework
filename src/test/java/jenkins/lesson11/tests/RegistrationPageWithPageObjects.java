package jenkins.lesson11.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("run")
public class RegistrationPageWithPageObjects extends TestBase {

    TestData testData = new TestData();

    @Test
    void studentRegistrationFormTest() {

        step("Open Registration Page and fill fields", () -> {
            registrationPage.openPage()
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.email)
                    .setGender(testData.gender)
                    .setTelNumber(testData.telNumber)
                    .setBirthDay(
                            testData.dayMonthYear[0],
                            testData.dayMonthYear[1],
                            testData.dayMonthYear[2])
                    .setSubjects(testData.subject)
                    .setHobbies(testData.hobbies)
                    .setPicture(testData.picture)
                    .setAddress(testData.address)
                    .setState(testData.state)
                    .setCity(testData.city);
        });

        step("Click button Submit", () -> {
            registrationPage.clickSubmitButton();
        });

        step("Verify results Modal appears", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Student Name", testData.firstName + " " + testData.lastName)
                    .verifyResult("Student Email", testData.email)
                    .verifyResult("Gender", testData.gender)
                    .verifyResult("Mobile", testData.telNumber)
                    .verifyResult("Date of Birth", testData.dateOfBirth)
                    .verifyResult("Subjects", testData.subject)
                    .verifyResult("Hobbies", testData.hobbies)
                    .verifyResult("Picture", testData.picture)
                    .verifyResult("Address", testData.address)
                    .verifyResult("State and City", testData.state + " " + testData.city);
        });
    }
}
