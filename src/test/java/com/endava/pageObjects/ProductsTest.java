package com.endava.pageObjects;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by crtanasescu on 8/1/2016.
 */

public class ProductsTest extends TestBaseClass {
    protected static WebDriver webDriver;
    @Test
    public void ClickOnIngrijire()
    {
        //Click on "Ingrijire corp" tab.
        ProductListPage productListPage =  homePage.clickOnTabIngrijire();


        //inchidere notificare
        productListPage.inchiderePopUp();


        // Verify how many products are in the selected category.
        Integer totalProductsNumber = productListPage.getTotalProducts();
        System.out.println("Total products: "  + totalProductsNumber);
        assertTrue(totalProductsNumber>0);


        // Filter by the highest price .
        productListPage.clickOnFilter();
        productListPage.clickOnFiltruPret();


        // Print the name and price for the first value returned.
        // UPDATE: If there is no price, print ‘unspecified price’ message.
        String name = productListPage.nume();
        String price = productListPage.pret();
        System.out.println("Numele produsului cu pretul cel mai mare este: " +  name);
        if (price == null) {
            System.out.println("Unspecified price");
        } else {
            System.out.println("Pretul produsului este: " + price);
        }


        //Select the first item returned.
        productListPage.waitForPage();
        ProductDetailPage productDetailPage = productListPage.redirectionarePagina();


        //Verify the product selected is the desired one.
        String numeProdusDetalii = productDetailPage.NameToVerify();
        assertEquals(name, numeProdusDetalii);


        //Click on the “Inapoi Inrijire Corp” link (top left)
        productDetailPage.inapoiClick();


        //Once redirected to “Ingrijire Corp” page click on ‘NOUTATI’ link.
        productListPage.clickOnNoutati();


        //Print the number of the new products (can be used asserts too)
        Integer totalProduseNoi  = productListPage.getProduseNoi();
        System.out.println("Total new products: "  + totalProduseNoi);
        assertTrue(totalProduseNoi>0);


        //Click on the 2nd product and then click on "Adauga in cos" button (before clicking verify the button is displayed).
        productListPage.clickPeAlDoileaProdusNou();
        productDetailPage.clickAdaugaInCos();


        //Check that the shopping cart (upper right of the page) is automatically updated with the new item added.
        productDetailPage.productAdded();


        //After the shopping basket icon is clicked, go to the products section and increase the quantity of the selected item to be  3.
        ProductCartPage productCartPage =  productDetailPage.redirectionarePaginaCos();
        productCartPage.clickIncreaseCantity();


        //Verify the total price and print the number of earned points.
        productCartPage.waitForPage();
        Double afisarePretPerProdus = productCartPage.getPretProdusAdaugat();
        System.out.println("Pretul produsului este: " + afisarePretPerProdus);
        Double afisarePretTotal = productCartPage.getPretFinal();
        System.out.println("Pretul total al comenzii este: " + afisarePretTotal);
        Double a = afisarePretPerProdus * 3;
        assertEquals(a, afisarePretTotal);


        Double puncte = productCartPage.afisareTotalPuncteAcumulate();
        System.out.println("Totalul punctelor acumulate este de: " + puncte);



        ////OPTIONAL
        //Click on "Pentru EL" tab
        productCartPage.clickPtEl();

        //In the left side of the page - click on "Ceasuri" - under the Accesorii category

        productListPage.clickPeAccesorii();
        productListPage.clickPeCeasuri();


        //Go to the last item returned and print the name and the number of stars displayed.
        System.out.println("Numele ultimului ceas este: " +  productListPage.afisareNumeCeas() + ", iar numarul de stele este: " + productListPage.returnareStelute() );

        //Click on the last item.
        productListPage.clickPeNumeCeas();

        //In the order page, verify the email share icon is displayed (under INFORMATII LIVRARE section).
        assertTrue(productDetailPage.verificareIconitaVizibila());

        //Click on the email icon to share.(verify the URL for the new page )
        EmailPage emailPage = productDetailPage.clickPeIconitaEmail();
        String redirected_url =  emailPage.GetCurrentUrl();
        assertTrue(redirected_url.contains("www.addthis.com"));

    }

}


