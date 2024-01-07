package com.tientd0802.CucumberAF.pageObjects;

import com.tientd0802.CucumberAF.base.BasePage;
import com.tientd0802.CucumberAF.customAnotation.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginPage extends BasePage {

    @Value("${web.url}")
    String webUrl;

    @FindBy(id = "user-name")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorMsg;

    public void accessToLoginPage(){
        pageActions.navigateToUrl(webUrl);
    }

    public void enterUsername(String username){
        pageActions.enterText(userNameField, username);
    }

    public void enterPassword(String password){
        pageActions.enterText(passwordField, password);
    }

    public void clickOnLoginButton(){
        pageActions.clickOnElement(loginBtn);
    }

    public void verifyErrorMessage(String message){
        pageActions.verifyElementContainsText(errorMsg, message);
    }

    public void getCurrentUrl(){
        System.out.println(webDriver.getCurrentUrl());
    }
}
