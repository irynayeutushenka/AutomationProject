package tests.config_app_tests.award_details_file_tests;

import business_objects.UserBO;
import business_objects.UserFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.config_app_pages.common_config_app_pages.IafHomePage;
import tests.common_test.BaseTest;

import static business_objects.TestClients.CLIENT_5012;
import static service_classes.login_service.LoginService.loginToIaf;

public class ChangePayrollCommentTest extends BaseTest {

    UserBO iafConsoleUser = UserFactory.createIafConsoleUser();

    @Test(description = "Successful adding new schedule for 5012 client")
    public void changePayrollComment() {
        logger.info("Log in into IAF");
        loginToIaf(getWebDriver(), iafConsoleUser);
        logger.info("Updating the comment of the payroll group");
        new IafHomePage(getWebDriver())
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
