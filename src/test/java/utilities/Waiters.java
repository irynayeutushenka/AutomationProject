package utilities;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

public class Waiters extends BasePage {

    public Waiters(WebDriver driver) {
        super(driver);
    }

    public static void waitUntilVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 20)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 20)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
