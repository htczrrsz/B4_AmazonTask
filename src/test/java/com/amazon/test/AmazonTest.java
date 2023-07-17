package com.amazon.test;

import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.YourListPage;
import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends TestBase{

    /** Amazon E2E Task
     *  go to amazon web page
     *  if there are cookies accept cookies
     *  log in with your own valid credential
     *  Verify that login is successful
     *  Create a new list from Account and Lists
     *  Select any category from the section tab next to the search box
     *  Verify that category  is selected
     *  Write any product to search box and click
     *  Verify that the result contains product items
     */


    LoginPage loginPage;
    HomePage homePage;
    YourListPage yourListPage;


   String listName="My Lists";
   String selectCategory="Computers";
   String searchSpecificProduct ="hp";


    @Test
    public void amazonTest1() throws InterruptedException {

        loginPage= new LoginPage();
        yourListPage=new YourListPage();
        homePage= new HomePage();
        extentLogger= report.createTest("Amazon E2E Test");
        extentLogger.info("Login with predefine credentials");
        loginPage.login();
        extentLogger.info("Verify that login is successful");
        homePage.verifyLogin();
        extentLogger.info("Create a new List from account and lists");
        yourListPage.createAList(listName);
        BrowserUtils.waitFor(2);
        extentLogger.info("Select any category from the section tab");
        homePage.selectCategories(selectCategory);


        extentLogger.info("Verify that category  is selected");
        BrowserUtils.waitFor(3);
        homePage.verifySelectedMenu(selectCategory);

        extentLogger.info("Write any product to search box and click");
        homePage.searchAnyProduct(searchSpecificProduct);

        extentLogger.info("Verify that the result contains product items");
        homePage.verifySelectedWord(searchSpecificProduct);

        extentLogger.pass("Passed");

    }


}
