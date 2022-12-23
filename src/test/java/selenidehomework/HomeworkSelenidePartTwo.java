package selenidehomework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class HomeworkSelenidePartTwo {

    @Test
    void pageEnterpriseIsOpen() {

        //открыть Github
        open("https://github.com/");
        //навести мышку на solutions и открыть страницу enterprize
        $(withText("Solutions")).hover();
        $$(".HeaderMenu-dropdown .HeaderMenu-dropdown-link").findBy(text("enterprise")).click();
        //проверка: открыта страница enterprise
        $("html").shouldHave(text("GitHub for enterprises"));

    }

    //Тест через Element dragAndDropTo работает
    @Test
    void elementDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        String pngFileName = screenshot("my_file_name");
        $("#column-b").shouldHave(text("A"));

    }

    //Actions() DragAndDrop сделать не удалось
    /*@Test
    void dragAndDrop() {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));
        Actions act = new Actions(driver);
        act.dragAndDrop(from, to).perform();
        $(to).shouldHave(text("A"));

    }*/
}