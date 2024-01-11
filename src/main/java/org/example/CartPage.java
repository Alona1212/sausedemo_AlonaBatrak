package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static io.opentelemetry.internal.shaded.jctools.queues.IndexedQueueSizeUtil.isEmpty;

public class CartPage extends BasePage{
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        //PageFactory.initElements(driver, this);
    }
    @FindBy (css = ".inventory_item_name")
    private WebElement itemName;

    public String getItemName (){return itemName.getText();}
    @FindBy (className = "cart_item")
    private List<WebElement> cartItems;
        public boolean isCartItemPresent(){
            boolean isEmpty = false;
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
      
                wait.until(ExpectedConditions.invisibilityOf(cartItems.get(0)));
            }
            catch (Exception ex){
                isEmpty = true;
            }
              return isEmpty;
    }

    public void clickOnCheckoutButton() {
    }
}
