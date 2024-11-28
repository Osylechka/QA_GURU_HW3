package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class QAguruHomeWork3 {

    @BeforeAll
    static void testsBeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // 4000 по умолчанию
    }

    @AfterAll
    static void closeWebDriver() {
        switchTo().window(getWebDriver().getWindowHandle()).close();
    }

    @Test
    void testAutomationPracticeForm() {
        open("/automation-practice-form");

        //заполнение полей с личными данными
        $("#firstName").setValue("Oss");
        $("#lastName").setValue("Klu");
        $("#userEmail").setValue("Moon@ya.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9996662233");

        //выбор даты рождения в выпадающем списке
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September"); //selectOption - выбор опции из выпадающего списка (по индексу) [https://selenide.org/javadoc/current/com/codeborne/selenide/SelenideElement.html]
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__day--004").click();

        //выбор чек-боксов с интересами
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        //выбор значения, вшитого в поле по умолчанию (выпадающий список)
        $("#subjectsInput").setValue("Arts").pressEnter();

        //загрузка изображения из директории
        $("#uploadPicture").uploadFromClasspath("mem.png"); //Upload file into file upload field

        //заполнение инфы далее
        $("#currentAddress").setValue("Fly to the Moon");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();

        $("#submit").click();

        //проверка модалки с данными
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //проверка данных в полях в модалке. sibling - Получаем следующий элемент-близнец этого элемента, например, $("td").элемент-близнец(0) выдаст первый следующий элемент-близнец "td".
        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Oss Klu"));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("Moon@ya.ru"));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("9996662233"));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("04 September,1987"));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports, Reading, Music"));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Arts"));
        $(".table").$(byText("Picture")).sibling(0).shouldHave(text("mem.png"));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text("Fly to the Moon"));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text("Haryana Panipat"));

        //закрытие модалки
        $("#closeLargeModal").click();
    }

}