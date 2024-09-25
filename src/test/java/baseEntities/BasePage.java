package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage {
    protected WebDriver pageDriver;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.pageDriver = driver;

    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return pageDriver.findElement(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        pageDriver.get(ReadProperties.getUrl() + pagePath);
    }
}
