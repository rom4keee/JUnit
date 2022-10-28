package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Basket extends BasicPage {
    public void clickCheckoutButton () {
        clickButton(checkoutButton);
    }

    @FindBy (xpath = "//dl[@class='total']//dd")
    private WebElement orderTotal;
    @FindBy (xpath = "/html/body/div[2]/div[5]/div/div[1]/div[2]/a[1]")
    private WebElement checkoutButton;
}
