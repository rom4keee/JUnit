package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import static Driver.WDriver.*;

public class BasicPage extends PageFactory {
    class CustomConditions {

        private void StringUtils() {
            throw new IllegalStateException();
        }

        }
    public BasicPage() {
        initElements(getDriver(), this);
    }

    protected void clickButton(WebElement webElement) {
        webElement.click();
    }

    protected String getElementText(WebElement webElement) {
        return webElement.getText();
    }

    protected String getTextFieldText(WebElement webElement) {
        return webElement.getAttribute("value");
    }

    protected void enterTextIntoField(WebElement webElement, String text) {
        webElement.sendKeys(text);
    }
}

