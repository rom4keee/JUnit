package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasicPage {
    public void clickAddToBasket() {
        clickButton(addToBasket);
    }

    @FindBy (xpath = "/html/body/div[3]/div[5]/div[2]/div[4]/div/div/div/div/div[4]/div[3]/div/a")
    private WebElement addToBasket;


}