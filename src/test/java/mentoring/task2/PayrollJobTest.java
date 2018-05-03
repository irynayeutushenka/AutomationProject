package mentoring.task2;

import mentoring.task2.ui.screens.PayrollJobSectionPage;
import mentoring.task2.ui.screens.SchedulerConsoleLoginPage;
import mentoring.task2.ui.screens.SchedulerConsolePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class PayrollJobTest {

    private WebDriver driver;

    private String userName = "tomcat-jobs";
    private String password = "tomcat-jobs";
    private String pageName = "Scheduler Console";

    private int clientId = 5003;
    private String date = "SYSDATE";
    private String payrollGroup = "US";

    private String successPayrollResult = "SUCCESS";


    @Parameters("browser")

    @BeforeTest(description = "Set up driver depending on browser")
    public void startDriver(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\ProjectForAutomation\\src\\test\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\IdeaProjects\\ProjectForAutomation\\src\\test\\resources\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.edge.driver", "D:\\IdeaProjects\\ProjectForAutomation\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(description = "Successful login to Scheduler Console", priority = 1)
    public void successLogin() {

        SchedulerConsoleLoginPage schedulerConsoleLoginPage = new SchedulerConsoleLoginPage(driver);
        schedulerConsoleLoginPage
                .openLoginPage()
                .typeLogin(userName)
                .typePassword(password)
                .clickSubmit();

        SchedulerConsolePage schedulerConsoleScreen = new SchedulerConsolePage(driver);
        Assert.assertEquals(schedulerConsoleScreen.getMainMenuLinkText(), pageName, "Page name is wrong");
    }

    @Test(description = "Triggering Payroll job is successful", priority = 2, dependsOnMethods = "successLogin")
    public void triggerPayrollJob() {
        SchedulerConsolePage schedulerConsolePage = new SchedulerConsolePage(driver);
        schedulerConsolePage
                .clickPayrollRunButton();

        WebElement explicitWait = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("job-parameters-container")));
        PayrollJobSectionPage payrollJobSectionPage = new PayrollJobSectionPage(driver);
        payrollJobSectionPage
                .typeClientId(clientId)
                .typeDate(date)
                .typePayrollGroup(payrollGroup)
                .clickStartJobButton();
    }

    @Test(description = "Verify the job run is successful", priority = 3, dependsOnMethods = "triggerPayrollJob")
    public void joResultVerification() {
        SchedulerConsolePage schedulerConsolePage = new SchedulerConsolePage(driver);
        Assert.assertEquals(schedulerConsolePage.getPayrollResultMessageText(), successPayrollResult,
                "Unexpected result of payroll job run");
    }

    @AfterClass(description = "Quit browser", alwaysRun = true)
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }
}
