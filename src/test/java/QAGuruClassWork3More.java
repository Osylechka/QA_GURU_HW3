package tests;
import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class QAGuruClassWork3More {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000 по умолчанию
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        //open("https://demoqa.com/text-box");
        $("#userName").setValue("burbur");
        $("#userEmail").setValue("oss@klu.ru");
        $("#currentAddress").setValue("Moon");
        $("#permanentAddress").setValue("Earth");
        $("#submit").click();

        $("#output #name").shouldHave(text("burbur"));
        $("#output #email").shouldHave(text("oss@klu.ru"));
        $("#output #currentAddress").shouldHave(text("Moon"));
        $("#output #permanentAddress").shouldHave(text("Earth"));
    }
}