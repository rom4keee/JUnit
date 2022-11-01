package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Basket extends HomePage {
    public void clickCheckoutButton () {
        clickButton(checkoutButton);
    }
    @FindBy (xpath = "/html/body/div[1]/div[5]/div/div[1]/div[2]/a[1]")
    private WebElement checkoutButton;
}
