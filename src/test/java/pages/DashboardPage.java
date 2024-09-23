package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.DropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private final By DROP_DOWN_TWO = By.xpath("//ul[@data-testid='dropdown-menu']");
    private final By DASHBOARD_PAGE_LOCATOR = By.xpath("//h1[@data-testid = 'text-dashboard-header-content']");
    private final By TEST_CASES_BUTTON_LOCATOR = By.xpath("//li[@data-testid = 'item-testcases']");
    private final By USER_SETTINGS_DROPDOWN_LOCATOR = By.xpath("//button[@data-testid = 'button-account']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return DASHBOARD_PAGE_LOCATOR;
    }

    public Button getTestCasesButton() {
        return new Button(pageDriver, TEST_CASES_BUTTON_LOCATOR);
    }

    public DropDown getUserDropDown() {
        return new DropDown(pageDriver, USER_SETTINGS_DROPDOWN_LOCATOR, DROP_DOWN_TWO);
    }

    public void clickTestCasesButton() {
        getTestCasesButton().click();
    }

    public void chooseSettingsDropDown(){
        getUserDropDown().selectByText("Settings");
    }
}
