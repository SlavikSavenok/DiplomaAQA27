package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyProfilePage extends BasePage {

    private final By PAGE_LOCATOR = By.xpath("//h3[text() = 'My profile']");
    private final By UPLOAD_AVATAR_BUTTON_LOCATOR = By.xpath("//div[text()='Upload avatar']");
    private final By SAVE_AVATAR_BUTTON_LOCATOR = By.xpath("//div[text()='Save']");
    private final By IMAGE_AVATAR_LOCATOR = By.xpath("//img[@alt='Avatar']");

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return PAGE_LOCATOR;
    }

    public UIElement getImageAvatarLocator() {
        return new UIElement(pageDriver, IMAGE_AVATAR_LOCATOR);
    }

    public Button getUploadAvatarButton() {
        return new Button(pageDriver, UPLOAD_AVATAR_BUTTON_LOCATOR);
    }

    public Button getSaveAvatarButton() {
        return new Button(pageDriver, SAVE_AVATAR_BUTTON_LOCATOR);
    }

    public void clickSaveAvatar() {
        getSaveAvatarButton().click();
    }

    public boolean isAvatarFileDisplayedOnScreen() {
        if (getImageAvatarLocator().isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

}
