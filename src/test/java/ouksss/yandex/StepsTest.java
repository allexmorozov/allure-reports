package ouksss.yandex;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class StepsTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    public void testLambdaTests() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу ", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").setValue("eroshenkoam/allure-example").submit();
        });

        step("Открываем репозиторий " + REPOSITORY, () -> {
            $(By.linkText("eroshenkoam/allure-example")).click();
        });

        step("Переходим в Issues ", () -> {
            $(By.partialLinkText("Issues")).click();
        });

        step("Проверяем, что в Issues есть число " + ISSUE_NUMBER,()->{
            $(withText("#68")).should(exist);
        });



    }
}
