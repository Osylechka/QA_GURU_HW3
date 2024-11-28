import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class QAguruHomeWork3 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // 4000 по умолчанию
    }
    @Test
    void testAutomationPracticeForm() {
        open("/automation-practice-form");
        $("#userName").setValue("burbur");
        $("#userEmail").setValue("oss@klu.ru");
        $("#currentAddress").setValue("Moon");
        $("#permanentAddress").setValue("Earth");
        $("#submit").click();
}
