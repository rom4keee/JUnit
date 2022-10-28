package Tests;

import org.junit.jupiter.api.*;

class FullTest extends PageTest {

    String email = "test@user.com";
    String expectedTotal = "19,22 €";
    String expectedSubTotal = "19,22 €";
    String expectedTax = "0,00 €";

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

        softAssertions.assertThat(PaymentPage.getEmailAddress()).as("Provided email address").isEqualTo(email);

        softAssertions.assertThat(PaymentPage.getOrderTotal()).as("Order total").isEqualTo(expectedTotal);

        softAssertions.assertThat(PaymentPage.getOrderSubTotal()).as("Order sub-total").isEqualTo(expectedSubTotal);
        
        softAssertions.assertThat(PaymentPage.getOrderTax()).as("Order tax").isEqualTo(expectedTax);

        softAssertions.assertAll();
    }
}