package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {




    public void verifyLogin(){
//        Assert.assertTrue(helloUsername.getText().contains(ConfigurationReader.get("username")));
        Assert.assertTrue(usernameAccountList.getText().contains(ConfigurationReader.get("username")));
    }


    public void  verifySelectedMenu(String selected){
        Assert.assertEquals(selected,select.getFirstSelectedOption().getText());
    }



    public void verifySelectedWord(String word){
        WebElement selectedWord=Driver.get().findElement(By.xpath("//span[text()='\""+word+"\"']"));
//        Assert.assertEquals(selectedWord.getText(),word);
        Assert.assertEquals("\"" +word+ "\"",resultWord.getText());
    }





}
