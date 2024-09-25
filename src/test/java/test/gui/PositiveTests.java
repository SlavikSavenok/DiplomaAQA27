package test.gui;

import baseEntities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class PositiveTests extends BaseTest {

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
}
