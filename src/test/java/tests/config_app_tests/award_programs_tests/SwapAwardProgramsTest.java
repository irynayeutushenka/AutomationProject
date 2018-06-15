package tests.config_app_tests.award_programs_tests;

import business_objects.UserBO;
import business_objects.UserFactory;
import page_objects.config_app_pages.common_config_app_pages.IafHomePage;
import tests.common_test.BaseTest;
import page_objects.config_app_pages.award_program_pages.AwardProgramsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static business_objects.TestClients.CLIENT_5021;
import static service_classes.login_service.LoginService.loginToIaf;

public class SwapAwardProgramsTest extends BaseTest {

    UserBO iafConsoleUser = UserFactory.createIafConsoleUser();

    @Test(description = "Successful swapping of award programs for 5021 client")
    public void swapAwardProgramsTest() {
        logger.info("Log in into IAF");
        loginToIaf(getWebDriver(), iafConsoleUser);
        new IafHomePage(getWebDriver())
                .openConfigApp()
                .clickClientLink(CLIENT_5021.getConfigAppName())
                .moveToAwardPrograms();

        String textInitial = new AwardProgramsPage(getWebDriver())
                .getTextOfFirstProgram();
        logger.info("1st program BEFORE movement is " + textInitial);

        new AwardProgramsPage(getWebDriver())
                .moveAwardProgram();
        String textUpdated = new AwardProgramsPage(getWebDriver()).getTextOfFirstProgram();
        logger.info("1st program AFTER movement is " + textUpdated);

        if (textInitial.contains("testclient5021 program")) {
            Assert.assertTrue(textUpdated.contains("Service Anniversaries"));
        }
        if (textInitial.contains("Service Anniversaries")) {
            Assert.assertTrue(textUpdated.contains("testclient5021 program"));
        }
    }
}

