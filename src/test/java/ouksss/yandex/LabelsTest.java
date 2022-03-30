package ouksss.yandex;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    @Owner("allexmorozov")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Tasks in the repo")
    @Story("Create a new task")
    @DisplayName("Verifying the creation of an Issue for an authorized user")
    @Description("This test checks for an Issue to be created when....")
    @Link(value = "Testing", url = "https://github.com")
    public void testAnnotatedLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.label("owner", "allexmorozov");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.getLifecycle().updateFixture(testCase -> {
            testCase.setName("Verifying the creation of an Issue for an authorized user");
        });
        Allure.feature("Tasks in the repo");
        Allure.story("Remove a new task");
        Allure.description("This test checks for an Issue to be created when....");
        Allure.link("Testing", "https://github.com");
    }
}
