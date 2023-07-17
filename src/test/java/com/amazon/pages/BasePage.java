package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }



    Select select;
    WebDriverWait wait;

    @FindBy(css = "#searchDropdownBox")
    public WebElement allCategories;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement helloUsername;

    @FindBy(xpath = "//div[@class='nav-line-1-container']")
    public WebElement usernameAccountList;

    @FindBy(xpath = "(//span[text()='Sign in'])[1]")
    public WebElement signInButton;

    @FindBy(xpath = "//span[text()='Create a List']")
    public WebElement createAList;

    @FindBy(id = "searchDropdownBox")
    public WebElement allCategoriesButton;


    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchInputBox;


    @FindBy(css = "[class='a-color-state a-text-bold']")
    public WebElement resultWord;


    @FindBy(css = "#nav-search-submit-button")
    public WebElement searchButton;


    public void getLoginPage(){
        BrowserUtils.hover(helloUsername);
        signInButton.click();
    }


    public void searchAnyProduct(String specificProduct){
        searchInputBox.clear();
        searchInputBox.sendKeys(specificProduct);
        searchButton.click();

    }


    public void selectCategories(String categories)  {
        BrowserUtils.waitFor(2);
//        BrowserUtils.waitForVisibility(allCategories,5);
        select= new Select(allCategories);
//        select.selectByIndex(2);
        select.selectByVisibleText(categories);

    }



}
