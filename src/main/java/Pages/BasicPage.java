package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import Driver.WDriver;

import java.time.Duration;

public class BasicPage extends PageFactory {
    class CustomConditions {

        private void StringUtils() {
            throw new IllegalStateException("Utility class");
        }

        public static ExpectedCondition<Boolean> jQueryAJAXsCompleted() {
            return driver -> {
                assert driver != null;
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (window.jQuery != null) && (jQuery.active == 0);");
            };
        }
    }
    public BasicPage() {
        initElements(WDriver.getDriver(), this);
    }

    public void waitUntilPageIsLoaded() {
        new WebDriverWait(WDriver.getDriver(), Duration.ofSeconds(10)).until(CustomConditions.jQueryAJAXsCompleted());
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

