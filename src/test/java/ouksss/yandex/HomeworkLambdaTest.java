package ouksss.yandex;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class HomeworkLambdaTest {
    private static final String REPOSITORY = "allexmorozov/allure-reports";
    private static final String TEXT = "Issues";

    @Test
    public void lambdaIssuesTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open main page", () -> {
            open("https://github.com");
        });

        step("Find repo " + REPOSITORY, () -> {
            $(".header-search-input").setValue("allexmorozov/allure-reports").submit();
        });

        step("Open repo" + REPOSITORY, () -> {
            $(By.linkText("allexmorozov/allure-reports")).click();
        });

        step("Find text" + TEXT, () -> {
            $("body").shouldHave(text("Issues"));
        });

    }

    @Test
    public void testAnnotated() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        HomeworkWebSteps steps = new HomeworkWebSteps();

        steps.openMainPage();
        steps.searchRepo(REPOSITORY);
        steps.openRepo(REPOSITORY);
        steps.findText(TEXT);
    }
}
