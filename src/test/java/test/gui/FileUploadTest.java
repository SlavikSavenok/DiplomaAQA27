package test.gui;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(FileUploadTest.class);

    @Test
    public void fileUploadTest() throws InterruptedException {
        userStep.successfulLogin();
        dashboardPage.chooseSettingsDropDown();
        WebElement fileUploadElement = waitsService.presenceOfElementLocated(By.xpath("//*[@accept='image/jpeg, image/png, image/gif, image/webp, image/svg+xml']"));
       // String pathToFile="D:/Project/AQA27ONLDiplomaGroup_1/src/test/resources/data/dataForFileUploadTest/profile_avatar.jpg";
        String pathToFile = FileUploadTest.class.getClassLoader().getResource("data/dataForFileUploadTest/profile_avatar.jpg").getPath();
        System.out.println(pathToFile);
        fileUploadElement.sendKeys(pathToFile);
        // myProfilePage.clickUploadAvatar();
        myProfilePage.clickSaveAvatar();
        //Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "sample-zip-file.zip");


    }
}
