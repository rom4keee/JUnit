package Tests;

import Driver.WDriver;
import Pages.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class PageTest {
    protected static WebDriver driver;
    protected static String HOME_PAGE = "https://www.bookdepository.com/";

    Pages.HomePage HomePage;
    Pages.SearchResult SearchResult;
    Pages.Modal Modal;
    Pages.ProductPage ProductPage;
    Pages.Basket Basket;
    Pages.PaymentPage PaymentPage;


    protected SoftAssertions softAssertions = new SoftAssertions();

    @BeforeEach
    void setUpTest() {
        WDriver.getWebDriverInstance();
        driver = WDriver.getDriver();


        HomePage = new HomePage();
        SearchResult = new SearchResult();
        Modal = new Modal();
        ProductPage = new ProductPage();
        Basket = new Basket();
        PaymentPage = new PaymentPage();

        driver.manage().deleteAllCookies();
        driver.navigate().to(HOME_PAGE);
    }

    @AfterEach
    void tearDown() {
        WDriver.quitDriver();
    }
}
