package mentoring.task3_SeleniumGrid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverTest {

    @Parameters({"browser", "platform"})

    @Test(description = "Page title is correct")
    public void test(String browser, String platform) throws MalformedURLException {
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
        driver.get("https://www.globoforce.com/");
        Assert.assertEquals(driver.getTitle(), "Globoforce | Elevate Workplace Culture and Performance | Globoforce");
        driver.quit();
    }
}
