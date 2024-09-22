package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyProfilePage extends BasePage {

    private final By PAGE_LOCATOR = By.xpath("//h3[text() = 'My profile']");
    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return PAGE_LOCATOR;
    }
}
