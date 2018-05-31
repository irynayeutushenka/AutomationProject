package mentoring.common.pages;

        import org.openqa.selenium.StaleElementReferenceException;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebDriverException;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class BasePage {

    protected final WebDriver webdriver;

    public BasePage(WebDriver driver) {
        this.webdriver = driver;
        HtmlElementLoader.populatePageObject(this, this.webdriver);
    }

    public WebDriver getWebDriver() {
        return this.webdriver;
    }

    public void waitUntilVisible(WebElement element) {
        new WebDriverWait(getWebDriver(), 20)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
