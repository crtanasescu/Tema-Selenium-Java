package com.endava.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by crtanasescu on 8/1/2016.
 */
public class HomePage {


    //locatori
    @FindBy(xpath = "//a[@data-category='bath-body']")
    private WebElement tabIngrijireCorp;



    //constructor
    private WebDriver webDriver;
    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }



    //functii
    public ProductListPage clickOnTabIngrijire() {
        tabIngrijireCorp.click();

        ProductListPage productListPage = PageFactory.initElements(webDriver,ProductListPage.class);
        productListPage.waitForPage();
        productListPage.setWebDriver(webDriver);
        return productListPage;
    }



}