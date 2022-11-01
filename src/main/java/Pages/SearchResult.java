package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResult extends HomePage {
    public void findProductFromList(String containsText) {
        for (WebElement webElement :
                searchResults) {
            if (webElement.getText().contains(containsText)) {
                book = webElement;
            }
        }
    }

    public void openProductPage() {
        clickButton(book);
    }
    @FindBy(xpath = "//*[@id='book-search-form']//input[1]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "/html/body/div[2]/div[5]/div[2]/div[4]/div/div/div/div/div[4]/div[1]/a")
    private WebElement book;


}
