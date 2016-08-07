package com.endava.pageObjects;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by crtanasescu on 8/1/2016.
 */
public class TestBaseClass {
    protected static WebDriver webDriver;
    protected  HomePage homePage;

    @BeforeClass
    public static void setUp() {


        //Navigate to "www.oriflame.ro"
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://oriflame.ro");

    }




    @Before
    public void initPageObjects(){
        homePage = PageFactory.initElements(webDriver, HomePage.class);
    }

//    @AfterClass
//    public static void tearDown(){
//        webDriver.close();
//    }


}
