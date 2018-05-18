package mentoring.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver webDriver;

    @Parameters("browser")

    @BeforeMethod(description = "Set up webdriver depending on browser")
    public void startDriver(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            /*System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\AutomationProject\\src\\test\\resources\\drivers\\chromedriver.exe");*/
            System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromedriver.exe");
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            /*System.setProperty("webdriver.gecko.driver", "D:\\IdeaProjects\\AutomationProject\\src\\test\\resources\\drivers\\geckodriver.exe");*/
            System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\drivers\\geckodriver.exe");
            webDriver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
//            System.setProperty("webdriver.edge.driver", "D:\\IdeaProjects\\AutomationProject\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe");
            System.setProperty("webdriver.edge.driver", ".\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe");
            webDriver = new EdgeDriver();
        }
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @AfterMethod(description = "Quit browser", alwaysRun = true)
    public void closeWebDriver() {
        if (webDriver != null)
            webDriver.quit();
    }

    protected WebDriver getWebDriver() {
        return this.webDriver;
    }
}