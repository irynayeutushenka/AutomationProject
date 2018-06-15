package tests.common_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.DriverManagerFactory;
import utilities.DriverManager;

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
    public void quitWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    protected WebDriver getWebDriver() {
        return this.webDriver;
    }
}