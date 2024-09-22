package baseEntities;

import com.github.javafaker.Faker;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.DashboardPage;
import pages.TestCasePage;
import services.BrowsersService;
import services.WaitsService;
import steps.UserStep;
import utils.InvokedListener;

import java.util.Random;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected WaitsService waitsService;
    protected Faker faker;
    protected Random random;
    protected UserStep userStep;

    protected DashboardPage dashboardPage;
    protected TestCasePage testCasePage;

    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        waitsService = new WaitsService(driver);

        iTestContext.setAttribute("webdriver", driver);

        userStep = new UserStep(driver);
        dashboardPage = new DashboardPage(driver);
        testCasePage = new TestCasePage(driver);


        faker = new Faker();
        random = new Random();

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}