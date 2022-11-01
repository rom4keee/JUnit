package Tests;

import org.junit.jupiter.api.*;

class FullTest extends PageTest {

    String email = "test@user.com";
    String Total = "19,22 €";
    String SubTotal = "19,22 €";
    String Tax = "0,00 €";

    @Test
    void FullTest() {


        HomePage.searchInput("Camilla");
        HomePage.clickSearchButton();

        SearchResult.findProductFromList("Camilla");
        SearchResult.openProductPage();

        ProductPage.clickAddToBasket();

        Modal.clickBasketBtn();

        Basket.clickCheckoutButton();

        PaymentPage.enterEmailAddress(email);

        softAssertions.assertThat(PaymentPage.getEmailAddress()).isEqualTo(email);
        softAssertions.assertThat(PaymentPage.getOrderTotal()).isEqualTo(Total);
        softAssertions.assertThat(PaymentPage.getOrderSubTotal()).isEqualTo(SubTotal);
        softAssertions.assertThat(PaymentPage.getOrderTax()).isEqualTo(Tax);

        softAssertions.assertAll();
    }
}