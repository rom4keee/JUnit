package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends HomePage {
    public void clickAddToBasket() {
        clickButton(addToBasket);
    }

    @FindBy (xpath = "/html/body/div[1]/div[5]/div/div/div[1]/div[1]/div[3]/div/div[2]/a[1]")
    private WebElement addToBasket;


}