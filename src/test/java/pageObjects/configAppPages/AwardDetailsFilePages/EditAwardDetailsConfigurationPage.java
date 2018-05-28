package pageObjects.configAppPages.AwardDetailsFilePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;
import utilities.Waiters;

public class EditAwardDetailsConfigurationPage extends BasePage {

    public EditAwardDetailsConfigurationPage(WebDriver driver) {
        super(driver);
    }

    @Name("Comment section")
    @FindBy(id = "comment")
    private TextBlock commentSectionTextBlock;

    @Name("Encryption Checkbox")
    @FindBy(id = "useEncryption")
    private CheckBox encryptionCheckbox;

    @Name("Encryption Key Text Input")
    @FindBy(id = "encryptionKeyName")
    private TextInput encryptionKeyTextInput;

    @Name("Save Button")
    @FindBy(id = "saveConfiguration-button")
    private Button saveButton;

    public EditAwardDetailsConfigurationPage updatePayrollGroupComment(String text) {
        commentSectionTextBlock.clear();
        commentSectionTextBlock.sendKeys(text);
        return this;
    }

    public EditAwardDetailsConfigurationPage switchOnEncryption(String text) {
        if (!encryptionCheckbox.isSelected()) {
            encryptionCheckbox.click();
            Waiters.waitUntilVisible(getWebDriver(), encryptionKeyTextInput);
            encryptionKeyTextInput.sendKeys(text);
        }
        return this;
    }

    public AwardDetailsConfigurationPage saveConfiguration() {
        Waiters.waitUntilClickable(getWebDriver(), saveButton);
        saveButton.click();
        return new AwardDetailsConfigurationPage(getWebDriver());
    }
}
