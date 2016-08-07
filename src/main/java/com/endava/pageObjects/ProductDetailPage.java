package com.endava.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by crtanasescu on 8/3/2016.
 */
public class ProductDetailPage {


    //constructor
    private WebDriver webDriver;
    public ProductDetailPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }


    //locatori

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement verificareNume;


    @FindBy(xpath = "//span[@class='v-icon-side-menu-arrow-left']")
    private WebElement inapoi;


    //dupa revenirea pe pagina de detalii la produsele noi
    @FindBy(xpath = "//button[@id='addToBasketButton']")
    private WebElement adaugaInCos;


    @FindBy(xpath = "//li[@class='basket right']")
    private WebElement cosCumparaturi;


    @FindBy(xpath = "//a[@title='Email']")
    private WebElement iconitaVizibila;

    //functii
    public String NameToVerify(){
        String nameToVerify = verificareNume.getText();
        return nameToVerify;
    }

    public void inapoiClick() {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(inapoi));
        inapoi.click();
    }

    public void clickAdaugaInCos() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        if (webDriver.findElement(By.xpath("//button[@id='addToBasketButton']")).isDisplayed() ) {
            adaugaInCos.click();
        }
    }

    public void productAdded(){
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOf(cosCumparaturi));
        if(webDriver.findElement(By.xpath("//li[@class='basket right']")).isDisplayed()) {
            System.out.println("The item has been added to your cart");
        }
    }

    public ProductCartPage redirectionarePaginaCos() {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cosCumparaturi));
        cosCumparaturi.click();

        ProductCartPage productCartPage = PageFactory.initElements(webDriver, ProductCartPage.class);
        return productCartPage;
    }


    public boolean verificareIconitaVizibila(){
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOf(iconitaVizibila));
        if(iconitaVizibila.isDisplayed()){
            return true;
        }
        else{
            return false;
        }
    }

    public EmailPage clickPeIconitaEmail(){
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(iconitaVizibila));
        iconitaVizibila.click();
        EmailPage emailPage = PageFactory.initElements(webDriver, EmailPage.class);
        return emailPage;
    }
}
