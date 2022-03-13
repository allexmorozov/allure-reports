package ouksss.yandex;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTest {
    @Test
    public void testIssueSearch() {
        open("https://github.com");
        $(".header-search-input").setValue("eroshenkoam/allure-example").submit();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("#68")).should(exist);
        sleep(3000);
    }
}
