package 'tests'
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples3ClassWork3 {
    void cssXpath() {
        //<input type="email" class="inputtext" login_form_input_box" name="email" id="email" data-testid="email"> ---пример

        $("[data-testid=email]").setValue("1"); //идеальный способ - TOP!!! --------------------------
        $(by("data-testid", "email")).setValue("1");  //обращение к каждому элементу отдельно, по желанию
        $x("//*[@data-testid='email']").setValue("1"); //с помощью Xpath

        //<input type="email" class="inputtext" login_form_input_box" name="email" id="email"> --- А если нет дата-тест-id?

        $("[id=email]").setValue("1");
        $(by("id", "email")).setValue("1");
        $(byId("email")).setValue("1"); //в selenide обращение к id с помощью отдельной команды
        $("email").setValue("1"); //самое простое обращение - TOP!!! --------------------------------------
        $x("//*[@data-testid='email']").setValue("1");

        //<input type="email" class="inputtext" login_form_input_box" name="email"> --- без id вообще (макарошка, как обычно и бывает)

        $("[name=email]").setValue("1");
        $(by("name", "email")).setValue("1");
        $(byName("email")).setValue("1"); //в selenide обращение c помощью отдельной команды - TOP!! -----------------
        $x("//*[@name='email']").setValue("1");


        //<input type="email" class="inputtext" login_form_input_box"> совсем обрезано

        $("[class=inputtext][class=login_form_input_box]").setValue("1"); // -- обращение к каждому классу отдельно
        $(".inputtext.login_form_input_box").setValue("1");
        $(".login_form_input_box").setValue("1"); // супер-ТОП!!!! -------------------------------
        $("input.inputtext.login_form_input_box").setValue("1"); // можно с input (везде добавить, но не надо)

        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("1"); //example Xpath - фууууу


        // <div class="inputtext">
        //     <input type="email"   class="login_form_input_box"> ---- обращение к двум разным элементам черед пробел
        // </div>

        $(".inputtext .login_form_input_box").setValue("1");
        $(".inputtext").$(".login_form_input_box").setValue("1");
        $("div.inputtext").$(".input.login_form_input_box").setValue("1");
        $("div.inputtext .input.login_form_input_box").setValue("1");

        //<div>Hello, qa.guru!</div>

        $(byText("Hello, qa.guru!")); // поиск полного текста
        $(withText("Hello, qa.guru!")); //искать часть текста
        $x("//*[text()='Hello, qa.guru!']"); //Xpath - так нинада! фууу
        $x("//*[containts(text),'Hello, qa.guru!']"); //Xpath-------------TOP!!--------------

    }
}


