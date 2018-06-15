package tests.common_test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.DriverManagerFactory;
import utilities.DriverManager;
import utilities.ScreenshotUtils;
import utilities.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    private DriverManager driverManager;
    private WebDriver webDriver;

    @Parameters({"browser"})

    @BeforeClass
    public void beforeTest(@Optional("chrome") String browser) {
        driverManager = DriverManagerFactory.getManager(browser);
        webDriver = driverManager.getInstance();
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        ScreenshotUtils.captureScreenshot(getWebDriver(), result);
    }

    @AfterClass
    public void quitWebDriver() {
        webDriver.quit();
    }

    protected WebDriver getWebDriver() {
        return this.webDriver;
    }

    protected Logger logger = Logger.getLogger(this.getClass());


}