package tests.configAppTests.awardProgramsTests_task4_Actions;

import businessObjects.IafConsoleUser;
import tests.commonTest.BaseTest;
import pageObjects.configAppPages.AwardProgramPages.AwardProgramsPage;
import serviceClasses.loginService.LoginToIafApp;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static businessObjects.TestClients.CLIENT_5021;

public class SwapAwardProgramsTest extends BaseTest {

   private IafConsoleUser user = new IafConsoleUser();

   @Test(description = "Successful swapping of award programs for 5021 client", priority = 0)
    public void swapAwardProgramsTest() {
        new LoginToIafApp(getWebDriver())
                .loginToIaf(user)
                .openConfigApp()
                .clickClientLink(CLIENT_5021.getConfigAppName())
                .moveToAwardPrograms();

        Assert.assertTrue(getWebDriver().findElement
                        (By.xpath("//tbody[@class='yui-dt-data']/tr[1]//a[contains(text(),'testclient5021 program')]")).isDisplayed(),
                "unexpected initial order of elements");

        new AwardProgramsPage(getWebDriver())
                .moveAwardProgram();

        Assert.assertTrue(getWebDriver().findElement
                        (By.xpath("//tbody[@class='yui-dt-data']/tr[2]//a[contains(text(),'testclient5021 program')]")).isDisplayed(),
                "the order of elements has not changed");
    }
}

