package mentoring.task4_Actions;

import mentoring.commonTest.BaseTest;
import mentoring.task4_ConfigApp.ui.pages.AwardProgramsPage;
import mentoring.task4_ConfigApp.ui.pages.IafLoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwapAwardProgramsTest extends BaseTest {

    private final String username = "bhkb.jshcw@gqfozpkzgb.kbk";
    private final String password = "password1";

    @Test(description = "Successful swapping of award programs for 5021 client", priority = 0)
    public void swapAwardProgramsTest() {
        new IafLoginPage(getWebDriver())
                .loginToIaf(username, password)
                .openConfigApp()
                .clickClientLink()
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

