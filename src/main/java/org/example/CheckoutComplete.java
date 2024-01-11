package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete extends BasePage{
   // WebDriver driver;

    public CheckoutComplete(WebDriver driver) {
        super(driver);
        //   this.driver = driver;
     //   PageFactory.initElements(driver, this);
    }
    @FindBy(className = "complete-header")
    private WebElement completeHeader;
    public String getCompleteHeaderText (){
        return completeHeader.getText();
}}
