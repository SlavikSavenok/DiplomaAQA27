package test.gui;

import baseEntities.BaseGuiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class PositiveTests extends BaseGuiTest {

    @Description("Тест на загрузку файла")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "Тест на загрузку файла", description = "Тест на загрузку файла")
    public void fileUploadTest() {
        userStep.successfulLogin();
        dashboardPage.chooseSettingsDropDown();
        WebElement fileUploadElement = waitsService.presenceOfElementLocated(By.xpath("//input[@style='display: none;']"));
        String pathToFile = PositiveTests.class.getClassLoader().getResource("data" + File.separator + "dataForFileUploadTest" + File.separator + "profileAvatar.jpg").getPath().replace("/D", "D").replace("%5c", "/");
        fileUploadElement.sendKeys(pathToFile);
        myProfilePage.clickSaveAvatar();
        Assert.assertTrue(
                myProfilePage.isAvatarFileDisplayedOnScreen());
    }

    @Description("Тест на проверку отображения диалогового окна")
    @Severity(SeverityLevel.MINOR)
    @Test(testName = "Отображение диалогового окна", description = "Отображение диалогового окна")
    public void dialogWindowTest() {
        userStep.successfulLogin();
        dashboardPage.clickFeedbackButton();

        Assert.assertTrue(
                dashboardPage.isFeedbackDialogWindowDisplayed());
    }

    @Description("Тест на проверку всплывающего сообщения при невалидном логине")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "Тест на проверку всплывающего сообщения", description = "Тест на проверку всплывающего сообщения")
    public void popUpMessageTest() {
        userStep.invalidLogin();

        Assert.assertTrue(loginPage.isPopUpMessageWindowDisplayed());
        Assert.assertEquals(loginPage.textInvalidPopUpMessageWindow(),
                "Either your email address or your password is wrong. Please try again or recover your password.\n" +
                        "Create a new user, if you are not registered yet.");
    }

    @Description("Тест на создание сущности")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "Тест на создание сущности", description = "Тест на создание сущности")
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

    @Description("Тест на удаление сущности")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "Тест на удаление сущности", description = "Тест на удаление сущности")
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
