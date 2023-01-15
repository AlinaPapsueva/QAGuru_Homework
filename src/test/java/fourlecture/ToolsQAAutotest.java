package fourlecture;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ToolsQAAutotest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void studentRegistrationFormTest() {
        String firstName = "Cat";
        String lastName = "Dog";
        String email = "aaa@gmail.com";
        String gender = "Female";
        String telNumber = "1234567890";
        String month = "June";
        String year = "1997";
        String dateOfBirth = "09 June,1997";
        String subject = "English";
        String hobbies = "Music";
        String file = "C:\\Users\\papsu\\Downloads\\gory_ozero_les_467323_1920x1080.jpg";
        String picture = "gory_ozero_les_467323_1920x1080.jpg";
        String address = "Taganrog";
        String state = "NCR";
        String city = "Delhi";
        String stateAndCity = "NCR Delhi";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $$("label").findBy(text(gender)).click();
        $("#userNumber").setValue(telNumber);
        $("#dateOfBirthInput").click();
            $$(".react-datepicker__month-select option").findBy(text(month)).click();
            $$(".react-datepicker__year-select option").findBy(text(year)).click();
            $(".react-datepicker__day--009").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFile(new File(file));
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(firstName + " " + lastName), (text(email)),
                (text(telNumber)), (text(address)), (text(gender)),
                (text(dateOfBirth)), (text(subject)), (text(hobbies)),
                (text(hobbies)), (text(picture)), (text(stateAndCity)));
    }
}
