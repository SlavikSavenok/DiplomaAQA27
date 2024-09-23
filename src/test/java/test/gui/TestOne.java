package test.gui;

import baseEntities.BaseTest;
import org.testng.annotations.Test;

public class TestOne extends BaseTest {

    @Test
    public void oneTest() {
        userStep.successfulLogin();
        dashboardPage.clickTestCasesButton();
        testCasePage.clickAddTestCaseButton();
        testCasePage.setAddTitleTestCaseInput("sdgsd");
        testCasePage.getAddTypeDropDown().selectByText("Other");
    }
}
