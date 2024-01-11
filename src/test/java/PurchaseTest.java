//import Checkout.CheckoutInformation;
import org.example.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseTest extends BaseTest{
    public void successfulPurchase(){
        //Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        //Add 2 items to the cart
        inventoryPage.backPackAddToCart();
        inventoryPage.bikeLightAddToCart();
        //Go to cart page
        Header header = new Header(driver);
        header.clickOnShoppingCart ();
        //Go to checkout-step-one and enter data
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        CheckoutInformation checkout = new CheckoutInformation (driver);
        checkout.enterFirstName ("Jack");
        checkout.enterLastName ("Jackson");
        checkout.enterPostalCode ("48167");

        //Go to checkout-step-one and push finish button
       // checkout.clickOnContinueButton();
      ////  CheckoutOverviev checkoutOverviev = new CheckoutOverviev(driver);
      ////  checkoutOverviev.clickFinishButton();
        //Assert that purchase was success
        CheckoutComplete checkoutComplete = new CheckoutComplete (driver);
        assertEquals ("Thank you for your order!", checkoutComplete.getCompleteHeaderText());

    }
}
