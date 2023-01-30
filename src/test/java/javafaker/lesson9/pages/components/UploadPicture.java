package javafaker.lesson9.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class UploadPicture {

    public void uploadPicture(String picture) {
        $("#uploadPicture").uploadFromClasspath(picture);
    }
}
