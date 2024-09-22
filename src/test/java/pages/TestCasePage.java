package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.DropDown;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasePage extends BasePage {

    private final By DROP_DOWN_ONE = By.xpath("//ul[@data-testid='list-list-box']");
    private final By DROP_DOWN_TWO = By.xpath("//ul[@data-testid='dropdown-menu']");


    private final By TESTCASE_PAGE_LOCATOR = By.xpath("//h2[@data-testid='text-title']");
    private final By ADD_TESTCASE_BUTTON_LOCATOR = By.xpath("//button[@data-testid='button-add']");
    private final By ADD_TITLE_TESTCASE_INPUT_LOCATOR = By.xpath("//input[@data-testid='textbox-prop-title']");
    private final By ADD_OWNER_TESTCASE_DROPDOWN_LOCATOR = By.xpath("//div[@data-testid = 'selectbox-prop-owner_user_id']//button[@data-testid='button-open' and @title = 'Open dropdown']");
    private final By ADD_TEMPLATE_TESTCASE_DROPDOWN_LOCATOR = By.xpath("//div[@data-testid = 'selectbox-prop-template']//button[@data-testid='button-open' and @title = 'Open dropdown']");
    private final By ADD_PRIORITY_TESTCASE_DROPDOWN_LOCATOR = By.xpath("//div[@data-testid = 'selectbox-prop-priority']//button[@data-testid='button-open' and @title = 'Open dropdown']");
    private final By ADD_TYPE_TESTCASE_DROPDOWN_LOCATOR = By.xpath("//div[@data-testid = 'selectbox-prop-testcase_type']//button[@data-testid='button-open' and @title = 'Open dropdown']");
    private final By ADD_PRECONDITION_TESTCASE_INPUT_LOCATOR = By.xpath("//div[@data-testid = 'section-precondition']//div[@data-testid = 'textbox-edit']");
    private final By SAVE_TESTCASE_BUTTON_LOCATOR = By.xpath("//button[@data-testid = 'button-save-entity']");
    private final By TESTCASE_LOCATOR = By.xpath("//span[text() = 'TC-25']");
    private final By TESTCASE_MORE_DROPDOWN_LOCATOR = By.xpath("//tr[@data-testid = 'row-25']//button[@data-testid = 'button-more']");
    private final By DELETE_CONFIRMATION_TESTCASE_BUTTON_LOCATOR = By.xpath("//button[@data-testid = 'button-affirm']");

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return TESTCASE_PAGE_LOCATOR;
    }

    public Button getAddTestCasesButton() {
        return new Button(pageDriver, ADD_TESTCASE_BUTTON_LOCATOR);
    }

    public Input getAddTitleInput() {
        return new Input(pageDriver, ADD_TITLE_TESTCASE_INPUT_LOCATOR);
    }

    public DropDown getAddOwnerDropDown() {
        return new DropDown(pageDriver, ADD_OWNER_TESTCASE_DROPDOWN_LOCATOR, DROP_DOWN_ONE);
    }

    public DropDown getAddTemplateDropDown() {
        return new DropDown(pageDriver, ADD_TEMPLATE_TESTCASE_DROPDOWN_LOCATOR, DROP_DOWN_ONE);
    }

    public DropDown getAddPriorityDropDown() {
        return new DropDown(pageDriver, ADD_PRIORITY_TESTCASE_DROPDOWN_LOCATOR, DROP_DOWN_ONE);
    }

    public DropDown getAddTypeDropDown() {
        return new DropDown(pageDriver, ADD_TYPE_TESTCASE_DROPDOWN_LOCATOR, DROP_DOWN_ONE);
    }

    public Input getAddPreconditionInput() {
        return new Input(pageDriver, ADD_PRECONDITION_TESTCASE_INPUT_LOCATOR);
    }

    public Button getSaveTestCaseButton() {
        return new Button(pageDriver, SAVE_TESTCASE_BUTTON_LOCATOR);
    }

    public DropDown getMoreDropDown() {
        return new DropDown(pageDriver, TESTCASE_MORE_DROPDOWN_LOCATOR, DROP_DOWN_TWO);
    }

    public  Button getTestCase() {
        return new Button(pageDriver, TESTCASE_LOCATOR);
    }

    public Button getDeleteTestCaseButton() {
        return new Button(pageDriver, DELETE_CONFIRMATION_TESTCASE_BUTTON_LOCATOR);
    }

    public void clickAddTestCaseButton() {
        getAddTestCasesButton().click();
    }

    public void setAddTitleTestCaseInput(String title) {
        getAddTitleInput().write(title);
    }

    public void setAddPreconditionTestCaseInput(String precondition) {
        getAddPreconditionInput().write(precondition);
    }

    public void clickSaveTestCase() {
        getSaveTestCaseButton().click();
    }

    public void clickTestCase() {
        getTestCase().click();
    }
    public void clickDeleteTestCase() {
        getDeleteTestCaseButton().click();
    }
}
