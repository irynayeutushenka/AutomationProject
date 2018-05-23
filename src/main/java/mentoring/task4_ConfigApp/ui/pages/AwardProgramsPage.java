package mentoring.task4_ConfigApp.ui.pages;

import mentoring.common.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class AwardProgramsPage extends BasePage {

    @Name("Service Anniversaries Award Program")
    @FindBy(xpath = "//a[text() = 'Service Anniversaries']")
    private WebElement serviceAnniversariesAwardProgram;

    @Name("testclient5021 Award Program")
    @FindBy(xpath = "//a[text() = 'testclient5021 program']")
    private WebElement testclient5021AwardProgram;

    public AwardProgramsPage(WebDriver driver) {
        super(driver);
    }

    public AwardProgramsPage swapAwardPrograms() {
       /* List<WebElement> items = getWebDriver().findElements(By.xpath("//tbody[@class='yui-dt-data']/tr"));
        Actions actions = new Actions(getWebDriver());
        actions.dragAndDrop(items.get(1), items.get(0)).build().perform();*/

     /*new Actions(getWebDriver()).dragAndDrop(serviceAnniversariesAwardProgram.getWrappedElement(),
                testclient5021AwardProgram.getWrappedElement()).build().perform();*/

       /* new Actions(getWebDriver()).dragAndDrop(serviceAnniversariesAwardProgram,
                testclient5021AwardProgram).build().perform();

        new Actions(getWebDriver())
                .clickAndHold(serviceAnniversariesAwardProgram)
                .moveToElement(testclient5021AwardProgram)
                .release()
                .build()
                .perform();*/

        /*new Actions(getWebDriver()).clickAndHold(testclient5021AwardProgram.getWrappedElement())
                .moveByOffset(-1, 1)
                .moveToElement(serviceAnniversariesAwardProgram.getWrappedElement())
                .release(serviceAnniversariesAwardProgram.getWrappedElement())
                .build()
                .perform();*/

        return this;
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public AwardProgramsPage moveAwardProgram() {
        waitUntilVisible(testclient5021AwardProgram);
        scrollToElement(testclient5021AwardProgram);
        waitUntilVisible(serviceAnniversariesAwardProgram);
        scrollToElement(serviceAnniversariesAwardProgram);
        Actions builder = new Actions(webdriver);
        builder.dragAndDrop(testclient5021AwardProgram, serviceAnniversariesAwardProgram).perform();
        return this;
    }
}
