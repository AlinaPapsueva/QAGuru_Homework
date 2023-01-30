package javafaker.lesson9.tests;

import org.junit.jupiter.api.Test;

public class RegistrationPageWithPageObjects extends TestBase {

    TestData testData = new TestData();

    @Test
    void studentRegistrationFormTest() {


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

        registrationPage.clickSubmitButton();

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
    }
}
