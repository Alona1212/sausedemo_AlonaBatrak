package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformation extends BasePage {
    //WebDriver driver;
    public CheckoutInformation(WebDriver driver) {
        super(driver);
        // this.driver = driver;
       // PageFactory.initElements(driver, this);
    }
    @FindBy (id = "first-name")
    private WebElement firstNameField;
    @FindBy (id = "last-name")
    private WebElement lastNameField;
    @FindBy (id = "postal-code")
    private WebElement postalCodeField;
    @FindBy (id = "continue")
    private WebElement continueButton;

    public void enterFirstName (String firstNameValue){
        firstNameField.sendKeys(firstNameValue);
    }
    public void enterLastName (String lastNameValue){
        lastNameField.sendKeys(lastNameValue);

}
    public void enterPostalCode (String postalCodeValue){
        postalCodeField.sendKeys(postalCodeValue);
    }
    public void clickOnContinueButton (){
       continueButton.click();
    }}
