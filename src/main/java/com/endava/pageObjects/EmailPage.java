package com.endava.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * Created by crtanasescu on 8/5/2016.
 */
public class EmailPage {
   public  WebDriver webDriver;
    public EmailPage(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public String GetCurrentUrl()
    {

        String originalWindowHandle = webDriver.getWindowHandle();

        for(Iterator<String> i = webDriver.getWindowHandles().iterator(); i.hasNext(); ) {
            String windowHandle = i.next();
            if(windowHandle!=originalWindowHandle){
                webDriver.switchTo().window(windowHandle);
                if(webDriver.getTitle().contains("AddThis"))
                    break;
            }
        }
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        return webDriver.getCurrentUrl();
    }
}
