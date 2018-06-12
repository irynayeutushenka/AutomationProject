package tests.config_app_tests.award_programs_tests;

import business_objects.UserBO;
import business_objects.UserFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.config_app_pages.common_config_app_pages.IafHomePage;
import tests.common_test.BaseTest;
import page_objects.config_app_pages.award_program_pages.AwardProgramsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static business_objects.TestClients.CLIENT_5021;
import static service_classes.login_service.LoginService.loginToIaf;

public class SwapAwardProgramsTest extends BaseTest {

    UserBO iafConsoleUser = UserFactory.createIafConsoleUser();

    @Test(description = "Successful swapping of award programs for 5021 client", priority = 0)
    public void swapAwardProgramsTest() throws InterruptedException {
        loginToIaf(getWebDriver(), iafConsoleUser);
        new IafHomePage(getWebDriver())
                .openConfigApp()
                .clickClientLink(CLIENT_5021.getConfigAppName())
                .moveToAwardPrograms();

        String textInitial = getWebDriver().findElement
                (By.xpath("//tbody[@class='yui-dt-data']/tr[1]//a")).getText();
        System.out.println("1st program BEFORE movement is " + textInitial);

        if (textInitial.contains("testclient5021 program")) {
            new AwardProgramsPage(getWebDriver())
                    .moveAwardProgram();

            String textUpdated = getWebDriver().findElement
                    (By.xpath("//tbody[@class='yui-dt-data']/tr[1]//a")).getText();

            System.out.println("Case1: 1st program AFTER movement is " + textUpdated);

            Assert.assertTrue(textUpdated.contains("Service Anniversaries"));
        }
        if (textInitial.contains("Service Anniversaries")) {
            new AwardProgramsPage(getWebDriver())
                    .moveAwardProgram();

            String textUpdated = getWebDriver().findElement
                    (By.xpath("//tbody[@class='yui-dt-data']/tr[1]//a")).getText();

            System.out.println("Case2: 1st program AFTER movement is " + textUpdated);

            Assert.assertTrue(textUpdated.contains("testclient5021 program"));
        }
    }
}

