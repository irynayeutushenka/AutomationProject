package pageObjects.configAppPages.CommonConfigAppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.BasePage;
import org.openqa.selenium.WebDriver;

public class ConfigAppHomePage extends BasePage {

    public ConfigAppHomePage(WebDriver driver) {
        super(driver);
    }

    public CoreSettingsPage clickClientLink(String clientName) {
        WebElement clientLink = getWebDriver().findElement(By.linkText(clientName));
        clientLink.click();
        return new CoreSettingsPage(getWebDriver());
    }
}
