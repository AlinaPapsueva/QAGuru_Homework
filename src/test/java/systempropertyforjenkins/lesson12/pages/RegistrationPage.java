package systempropertyforjenkins.lesson12.pages;

import com.codeborne.selenide.SelenideElement;
import systempropertyforjenkins.lesson12.pages.components.CalendarComponent;
import systempropertyforjenkins.lesson12.pages.components.RegistrationResultsModal;
import systempropertyforjenkins.lesson12.pages.components.StateAndCitySelectors;
import systempropertyforjenkins.lesson12.pages.components.UploadPicture;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

// здесь в методах хранятся локаторы и действия теста
// изначальный простой вид теста лежит в lesson4
public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    UploadPicture uploadPicture = new UploadPicture();
    StateAndCitySelectors stateAndCitySelectors = new StateAndCitySelectors();
    RegistrationResultsModal registrationResultModal = new RegistrationResultsModal();

    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genterWrapperRadioButton = $("#genterWrapper"),
            telNumberInput = $("#userNumber"),
            dateOfBirthDay = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckBox = $("#hobbiesWrapper"),
            addressTextArea = $("#currentAddress"),
            submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genterWrapperRadioButton.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setTelNumber(String value) {
        telNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        dateOfBirthDay.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesCheckBox.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String picture) {
        uploadPicture.uploadPicture(picture);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressTextArea.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateAndCitySelectors.state(value);

        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        stateAndCitySelectors.city(value);

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);

        return this;
    }
}
