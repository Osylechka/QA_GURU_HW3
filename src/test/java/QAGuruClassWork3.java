import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import javax.print.DocFlavor;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class QAGuruHW3 {

int result;

@BeforeAll
static void beforeAllTest(){
    System.out.println("\n##__________beforeAllTest\n");
}

@BeforeEach
void beforeTests(){
    System.out.println("##   beforeTests");
    result = getResult();
}

@AfterEach
void afterTest(){
    System.out.println("##   afterTest\n");
    result = getResult();
}

@AfterAll
static void afterAllTests(){
    System.out.println("\n## _______afterAllTest\n");
}

@Test
    void firstTest(){
    int result = getResult();
    System.out.println("##      first");
    Assertions.assertTrue(result > 2);
}

@Test
    void secondTest(){
        int result = getResult();
        System.out.println("##      second");
        Assertions.assertTrue(result > 2);
}

@Test
        void thirdTest(){
            int result = getResult();
            System.out.println("##      third");
            Assertions.assertTrue(result > 2);
}
private int getResult(){
    return 3;
}

//    @BeforeAll
//    static void beforeAll() {
//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.pageLoadStrategy = "eager";

}