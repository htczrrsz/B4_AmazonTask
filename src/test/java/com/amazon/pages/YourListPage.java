package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourListPage extends BasePage{

//   String listName="My Lists";

    @FindBy(css = "[class='a-button-input']")
    public WebElement createAlistButton;

    @FindBy(id = "list-name")
    public WebElement listNameInputButton;

    @FindBy(xpath = "(//input[@class='a-button-input a-declarative'])[3]")
    public WebElement createListButton;

    @FindBy(xpath = "(//input[@class='a-button-input a-declarative'])[2]")
    public WebElement createListBtn;




    public void createAList(String listName) throws InterruptedException {
//        BrowserUtils.hover(helloUsername);
        BrowserUtils.hover(usernameAccountList);
        BrowserUtils.waitForVisibility(createAList,5);
        createAList.click();
        Thread.sleep(2000);
        try{
            createAlistButton.click();
            listNameInputButton.clear();
            listNameInputButton.sendKeys(listName);
            Thread.sleep(2000);
            createListButton.click();
        }
        catch (ElementNotInteractableException e){
            try{
                listNameInputButton.clear();
                listNameInputButton.sendKeys(listName);
                BrowserUtils.waitFor(2);
                createListBtn.click();
            }catch (NoSuchElementException ex){
                System.out.println(ex.getMessage());
            }

        }

    }



}
