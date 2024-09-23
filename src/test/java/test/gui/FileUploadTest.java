package test.gui;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(FileUploadTest.class);

    @Test
    public void fileUploadTest() {
        userStep.successfulLogin();
        dashboardPage.chooseSettingsDropDown();
        WebElement fileUploadElement = waitsService.presenceOfElementLocated(By.xpath("//input[@style='display: none;']"));
        String pathToFile = FileUploadTest.class.getClassLoader().getResource("data" + File.separator + "dataForFileUploadTest" + File.separator + "profileAvatar.jpg").getPath().replace("/D", "D").replace("%5c", "/");
        fileUploadElement.sendKeys(pathToFile);
        myProfilePage.clickSaveAvatar();
    }
}
