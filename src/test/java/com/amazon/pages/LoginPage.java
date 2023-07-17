package com.amazon.pages;

import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "ap_email")
    public WebElement emailInputBox;

//    @FindBy(id = "continue")
//    public WebElement continueButton;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy(id = "ap_password")
    public WebElement passwordInputBox;

    @FindBy(id = "signInSubmit")
    public WebElement signInButton;

    public void login() throws InterruptedException {
//        LoginPage loginPage= new LoginPage();
//        Driver.get().switchTo().frame()
        getLoginPage();
        Thread.sleep(2000);

        emailInputBox.sendKeys(ConfigurationReader.get("email"));
        continueButton.click();
        Thread.sleep(2000);
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        signInButton.click();
        Thread.sleep(2000);

    }

}
