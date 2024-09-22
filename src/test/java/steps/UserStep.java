package steps;

import baseEntities.BaseStep;
import configuration.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class UserStep extends BaseStep {
    public UserStep(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Логин")
    private void login(String username, String password) {
        loginPage.setEmailValue(username);
        loginPage.setPasswordValue(password);
        loginPage.clickLogin();
    }

    @Step(value = "Успешный логин")
    public void successfulLogin() {
        loginPage.setEmailValue(ReadProperties.username());
        loginPage.setPasswordValue(ReadProperties.password());
        loginPage.clickLogin();
    }

}
