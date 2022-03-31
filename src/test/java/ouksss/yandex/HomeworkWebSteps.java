package ouksss.yandex;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeworkWebSteps {

    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Find repo {repo}")
    public void searchRepo(String repo){
        $(".header-search-input").setValue("allexmorozov/allure-reports").submit();
    }

    @Step("Open repo {repo}")
    public void openRepo(String repo){
        $(By.linkText("allexmorozov/allure-reports")).click();
    }

    @Step("Find text {text}")
    public void findText(String text){
        $("body").shouldHave(text("Issues"));
    }
}
