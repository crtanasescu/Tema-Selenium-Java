package com.endava.pageObjects;

import jdk.nashorn.internal.runtime.Debug;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by crtanasescu on 8/1/2016.
 */
public class ProductListPage {


    // constructor
    private WebDriver webDriver;
    public ProductListPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }


    // locatori
    @FindBy(xpath = "//button[@class='k-button']")
    private WebElement popUp;

    @FindBy(xpath="//a[contains(@class,'ui-product-box')]")
    private List<WebElement> productList;

    @FindBy(xpath = "//div[@class='filter-count']/span[@class='total-count']")
    private WebElement totalProducts;

    @FindBy(xpath = "//span[@class='k-input']")
    private WebElement filtrareButton;

    @FindBy(xpath = "//ul[@id='top-filter_listbox']//li[@data-offset-index='2']")
    private WebElement filtruPret;

    @FindBy(xpath = "(//div[@class='w-info'])[1]/span[@class='name']")
    private WebElement nameOfProduct;

    @FindBy(xpath = "(//div[@class='w-info'])[1]//span[@class='price mainCurrency']")
    private WebElement priceOfProduct;

    @FindBy(xpath = "//a[contains(@style,'translate(0px, 0px);')]/div[@class='w-info']")
    private WebElement produs;

    @FindBy(xpath = "//a[@href='/bath-body/new']")
    private WebElement noutati;

    @FindBy(xpath = "//span[@class='total-count']")
    private WebElement produseNoi;

    @FindBy(xpath = "(//div[@class='w-info'])[2]/span[@class='name']")
    private WebElement produsNouDoi;



////////////////////////optional
    @FindBy(xpath = "//a[@href='/men/accessories']")
    private WebElement accesorii;
    @FindBy(xpath = "//a[@href='/men/accessories/watches']")
    private WebElement ceasuri;
    @FindBy(xpath = "(//span[@class='name'])[3]")
    private WebElement numeCeas;
    @FindBy(xpath = "(//span[@class='stars'])[3]")
    private WebElement stelute;


    //functii
    public void inchiderePopUp(){
        try {
            if (popUp.isDisplayed()) {
                WebDriverWait wait = new WebDriverWait(webDriver, 5);
                wait.until(ExpectedConditions.elementToBeClickable(popUp));
                popUp.click();
            }
        }
        catch(NoSuchElementException ex)
        {
            return;
        }
    }

    public void waitForPage(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(productList));

    }

    public int getTotalProducts(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(totalProducts));
        String totalProductsField = totalProducts.getText();
        return Integer.parseInt(totalProductsField);
    }

    public void clickOnFilter() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(filtrareButton));
        filtrareButton.click();
    }

    public void clickOnFiltruPret() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(filtruPret));
        filtruPret.click();
    }

    public String nume(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(nameOfProduct));
        String numeleProdusului = nameOfProduct.getText();
        return numeleProdusului;
    }

    public String pret() {
        if (priceOfProduct == null) {
            return null;
        } else {
            return priceOfProduct.getText();
        }
    }

    public ProductDetailPage redirectionarePagina() {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(nameOfProduct));
        nameOfProduct.click();
        ProductDetailPage productDetailPage = PageFactory.initElements(webDriver, ProductDetailPage.class);
        return productDetailPage;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void clickOnNoutati() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(noutati));
        noutati.click();
    }

    public int getProduseNoi(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(produseNoi));
        String totalProduseNoi = produseNoi.getText();
        return Integer.parseInt(totalProduseNoi);
    }

    public void clickPeAlDoileaProdusNou() {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(produsNouDoi));
        produsNouDoi.click();
    }




    //optional
    public void clickPeAccesorii(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(accesorii));
        accesorii.click();
    }
    public void clickPeCeasuri(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(ceasuri));
        ceasuri.click();
    }
    public String afisareNumeCeas(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(numeCeas));
        String ceas = numeCeas.getText();
        return ceas;
    }
    public Integer returnareStelute(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(stelute));
        String stea = stelute.getText();
        return Integer.parseInt(stea);
    }
    public void clickPeNumeCeas(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(numeCeas));
        numeCeas.click();
    }

}