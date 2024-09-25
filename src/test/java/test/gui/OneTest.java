package test.gui;

import baseEntities.BaseGuiTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import elements.UIElement;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OneTest extends BaseGuiTest {
    @Test
    public void addTestCase() {
        TestCase testCaseBuilder = TestCase
                .builder()
                .title("AQA27Onl")
                .owner("Diplom Diplom")
                .template("Text")
                .priority("Medium")
                .type("Acceptance")
                .precondition(faker.company().bs())
                .steps(faker.company().bs())
                .expectedResults(faker.company().bs())
                .build();
        userStep.successfulLogin();
        dashboardPage.clickTestCasesButton();
        testCasePage.addTestCase(testCaseBuilder);
        Assert.assertEquals(waitsService.presenceOfElementLocated(By.xpath("//td//span[text() = 'AQA27Onl']")).getText(), testCaseBuilder.getTitle());
        testCasePage.getMoreDropDown().selectByText("Delete");
        testCasePage.clickDeleteTestCase();
    }

    @Test
    public void deleteTestCaseTest() {
        TestCase testCaseBuilder = TestCase
                .builder()
                .title("TestCaseForDelete")
                .owner("Diplom Diplom")
                .template("Text")
                .priority("Medium")
                .type("Acceptance")
                .precondition(faker.company().bs())
                .steps(faker.company().bs())
                .expectedResults(faker.company().bs())
                .build();
        userStep.successfulLogin();
        dashboardPage.clickTestCasesButton();
        testCasePage.addTestCase(testCaseBuilder);
        testCasePage.getMoreDropDown().selectByText("Delete");
        testCasePage.clickDeleteTestCase();
        Assert.assertTrue(waitsService.presenceOfElementLocated(By.xpath("//*[text() = 'Create test cases']")).isDisplayed());
    }
}

