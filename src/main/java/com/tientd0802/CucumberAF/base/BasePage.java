package com.tientd0802.CucumberAF.base;

import com.tientd0802.CucumberAF.customAnotation.LazyAutowire;
import com.tientd0802.CucumberAF.utils.PageActions;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class BasePage {

    @Autowired
    @Lazy
    protected WebDriver webDriver;

    @Autowired
    @Lazy
    protected PageActions pageActions;

    @PostConstruct
    protected void initPageFactory(){
        PageFactory.initElements(this.webDriver, this);
    }
}
