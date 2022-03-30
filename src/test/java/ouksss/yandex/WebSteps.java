package ouksss.yandex;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Find repo {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").setValue(repo).submit();
    }

    @Step("Open repo {repo}")
    public void openRepository(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Go to tab Issues")
    public void openIssueTab(){
        $(By.partialLinkText("Issues")).click();
    }

    @Step("Check that there is an Issue with a number {num} ")
    public void shouldSeeIssueWithNumber(int num){
        $(withText("#68")).should(exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
