package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Modal extends BasicPage {
    public void clickBasketBtn() {
        waitUntilPageIsLoaded();
        clickButton(basketButton);
    }

    @FindBy (xpath = "//a[@data-default-localized-pattern='Basket / Checkout']")
    private WebElement basketButton;
}
