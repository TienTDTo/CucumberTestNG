package com.tientd0802.CucumberAF.utils;


import com.tientd0802.CucumberAF.customAnotation.LazyAutowire;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

@Component
public class PageActions {

    @Autowired
    @Lazy
    WebDriver webDriver;

    @Autowired
    @Lazy
    WebDriverWait wait;

    public void waitUntilElementIsDisplayed(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilElementClickable(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void enterText(WebElement webElement, String text){
        waitUntilElementClickable(webElement);
        webElement.sendKeys(text);
    }

    public void clickOnElement(WebElement webElement){
        waitUntilElementClickable(webElement);
        webElement.click();
    }

    public String getInnerText(WebElement webElement){
        waitUntilElementIsDisplayed(webElement);
        return webElement.getText();
    }


    public void navigateToUrl(String url){
        webDriver.navigate().to(url);
    }

    public void verifyElementContainsText(WebElement webElement, String text){
        waitUntilElementIsDisplayed(webElement);
        String actualText = webElement.getText();
        //SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(actualText,text.trim());
    }

    public void verifyPageContainsElements(List<WebElement> elements){
        Assert.assertTrue(elements.size() > 0);
    }

    public void verifyCurrentUrlContainsFraction(String fraction){
        Assert.assertTrue(webDriver.getCurrentUrl().contains(fraction),webDriver.getCurrentUrl());
    }

    public void selectDropdownListItem(WebElement selectorElement, String value){
        Select filterSelector = new Select(selectorElement);
        filterSelector.selectByValue(value.toLowerCase());
    }


    public List<String> getListInnerText(List<WebElement> listElement){
        List<String> texts = new ArrayList<>();

        for(WebElement element: listElement){
            texts.add(element.getText().replace("$",""));
        }

        return texts;
    }



}
