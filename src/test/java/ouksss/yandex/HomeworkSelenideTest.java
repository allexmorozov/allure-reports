package ouksss.yandex;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeworkSelenideTest {
    @Test
    public void testIssueText(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").setValue("allexmorozov/allure-reports").submit();
        $(By.linkText("allexmorozov/allure-reports")).click();
        $("body").shouldHave(text("Issues"));

    }
}
