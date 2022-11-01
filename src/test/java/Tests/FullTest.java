package Tests;

import Pages.*;
import Driver.WDriver;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


class FullTest {

    String email = "test@user.com";
    String Total = "23,69 €";
    String SubTotal = "23,69 €";

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


    @Test
    void FullTest() {

        Pages.HomePage.clickAcceptCookieButton();

        Pages.HomePage.searchInput("Camilla");
        Pages.HomePage.clickSearchButton();

        SearchResult.findProductFromList("Camilla");
        SearchResult.openProductPage();

        ProductPage.clickAddToBasket();

        Modal.clickBasketBtn();

        Basket.clickCheckoutButton();

        PaymentPage.enterEmailAddress(email);

        softAssertions.assertThat(PaymentPage.getEmailAddress()).isEqualTo(email);
        softAssertions.assertThat(PaymentPage.getOrderTotal()).isEqualTo(Total);
        softAssertions.assertThat(PaymentPage.getOrderSubTotal()).isEqualTo(SubTotal);

        softAssertions.assertAll();
        driver.quit();
    }
}