package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasicPage {
    public void searchInput(String s) {
        searchField.sendKeys(s);
    }

    public void clickSearchButton() {
        clickButton(searchButton);
    }

    @FindBy(xpath = "//*[@id='book-search-form']//input[1]")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='header-search-btn']")
    private WebElement searchButton;

}
