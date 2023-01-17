package pageobjects.lesson6.tests;

import org.junit.jupiter.api.Test;

public class RegistrationPageWIthPageObjects extends TestBase {

    @Test
    void studentRegistrationFormTest() {
        String firstName = "Cat";
        String lastName = "Dog";
        String email = "aaa@gmail.com";
        String gender = "Female";
        String telNumber = "1234567890";
        String dateOfBirth = "09 June,1997";
        String subject = "English";
        String hobbies = "Music";
        String picture = "gory_ozero_les_467323_1920x1080.jpg";
        String address = "Taganrog";
        String state = "NCR";
        String city = "Delhi";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setTelNumber(telNumber)
                .setBirthDay("09", "June", "1997")
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city);

        registrationPage.clickSubmitButton();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", telNumber)
                .verifyResult("Date of Birth", dateOfBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }
}
