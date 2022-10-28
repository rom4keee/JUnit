package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasicPage {
    public void clickAddToBasket() {
        waitUntilPageIsLoaded();
        clickButton(addToBasket);
    }

    @FindBy (xpath = "//a[@class='btn btn-primary add-to-basket']")
    private WebElement addToBasket;


}