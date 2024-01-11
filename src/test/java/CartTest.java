import org.example.CartPage;
import org.example.Header;
import org.example.InventoryPage;
import org.example.LoginPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTest extends BaseTest{

    @Test
    public void checkCartBadgeWithQuantity1Item(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.backPackAddToCart();
        Header header = new Header(driver);
        assertEquals(1,header.getQuantityOfCartBadge());
    }
    @Test
    public void checkCartBadgeWithQuantity3Item() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.backPackAddToCart();
        inventoryPage.bikeLightAddToCart();
        inventoryPage.tShirtAddToCart();
        Header header = new Header(driver);
        assertEquals(3,header.getQuantityOfCartBadge());
    }
    @Test
    public void backpackAddedToCart(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.backPackAddToCart();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.getItemName().contains("Sauce Labs Backpack"));
    }
    @Test
    public void emptyCart ()throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        Header header = new Header(driver);
        header.clickCartLink();
        CartPage cartPage = new CartPage (driver);
        assertTrue(cartPage.isCartItemPresent());

    }
}
