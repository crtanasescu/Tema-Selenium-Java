package com.endava.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by crtanasescu on 8/4/2016.
 */
public class ProductCartPage {


    //constructor
    private WebDriver webDriver;

    public ProductCartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //locatori
    @FindBy(xpath = "//span[@title='Increase value']")
    private WebElement increaseCantity;


    @FindBy(xpath = "(//span[@class='price'])[1]/span")
    private WebElement pretulProdusuluiAdaugat;

    @FindBy(xpath = "(//span[@class='value'])[1]")
    private WebElement totalPretComanda;


    @FindBy(xpath = "//span[@class='total-bp']")
    private WebElement totalPuncteAcumulate;


    @FindBy(xpath = "(//a[@href='/men'])[@data-category='men']")
    private WebElement pentruEl;


    //functii
    public void clickIncreaseCantity() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(increaseCantity));
        increaseCantity.click();
        increaseCantity.click();
    }


    private Double convert(String text) {
        try {
            NumberFormat nf = NumberFormat.getInstance(new Locale("ro"));
            return nf.parse(text).doubleValue();
        }
        catch(Exception ex){
            return Double.valueOf(0);
        }
    }

    public Double getPretProdusAdaugat(){
        return convert(pretulProdusuluiAdaugat.getText().substring(0,5));
    }

    public Double getPretFinal() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(totalPretComanda));

        return convert(totalPretComanda.getText().substring(0, 5));
    }

    public Double afisareTotalPuncteAcumulate() {
        return convert(totalPuncteAcumulate.getText().substring(0,5));
    }

    public void waitForPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(totalPretComanda));
    }

    public void clickPtEl() {
        pentruEl.click();
    }
}
