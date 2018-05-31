package tests.configAppTests.awardDetailsFileTests;

import businessObjects.IafConsoleUser;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import serviceClasses.loginService.LoginToIafApp;
import tests.commonTest.BaseTest;

import static businessObjects.TestClients.CLIENT_5012;

public class ChangePayrollCommentTest extends BaseTest {

    private IafConsoleUser user = new IafConsoleUser();

    @Test(description = "Successful adding new schedule for 5012 client", priority = 0)
    public void changePayrollComment() {
        new LoginToIafApp(getWebDriver())
                .loginToIaf(user)
                .openConfigApp()
                .clickClientLink(CLIENT_5012.getConfigAppName())
                .moveToAwardDetailsConfiguration()
                .clickFirstPayrollGroupLink()
                .updatePayrollGroupComment("New Comment")
                .switchOnEncryption("test key")
                .saveConfiguration();

        Assert.assertTrue(getWebDriver().findElement
                        (By.xpath("//div[contains(text(),'New Comment')]")).isDisplayed(),
                "Unexpected comment ");
    }
}
