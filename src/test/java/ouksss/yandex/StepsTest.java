package ouksss.yandex;


import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;


public class StepsTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    public void testLambdaTests() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open main page", () -> {
            open("https://github.com");
        });

        step("Find repo " + REPOSITORY, () -> {
            $(".header-search-input").setValue("eroshenkoam/allure-example").submit();
        });

        step("Open repo " + REPOSITORY, () -> {
            $(By.linkText("eroshenkoam/allure-example")).click();
        });

        step("Go to tab Issues ", () -> {
            $(By.partialLinkText("Issues")).click();
            addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
        });

        step("Check that there is an Issue with a number " + ISSUE_NUMBER, () -> {
            $(withText("#68")).should(exist);
        });


    }

    @Test
    public void testAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());


        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);

        steps.takeScreenshot();
    }
}
