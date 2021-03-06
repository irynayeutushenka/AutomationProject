package tests.login_to_globofoce_selenium_grid;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverTest {

    protected Logger logger = Logger.getLogger(this.getClass());

    @Parameters({"browser", "platform"})

    @Test(description = "Page title is correct")
    public void test(@Optional("chrome") String browser, @Optional("WINDOWS") String platform) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        if (platform.equalsIgnoreCase("WINDOWS")) {
            cap.setPlatform(Platform.WINDOWS);
        } else if (platform.equalsIgnoreCase("LINUX")) {
            cap.setPlatform(Platform.LINUX);
        }

        if (browser.equalsIgnoreCase("chrome")) {
            cap.setBrowserName("chrome");
        } else if (browser.equalsIgnoreCase("firefox")) {
            cap.setBrowserName("firefox");
        } else if (browser.equalsIgnoreCase("ie")) {
            cap.setBrowserName("ie");
        }
        URL url = new URL("http://10.9.126.6:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(url, cap);
        logger.info("Checking Globoforce title");
        driver.get("https://www.globoforce.com/");
        Assert.assertEquals(driver.getTitle(), "Globoforce | Elevate Workplace Culture and Performance | Globoforce");
        driver.quit();
    }
}
