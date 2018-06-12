package page_objects.config_app_pages.common_config_app_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page_objects.BasePage;
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
