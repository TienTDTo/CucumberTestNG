package com.tientd0802.CucumberAF.webdriverconfig;


import io.cucumber.spring.ScenarioScope;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

import java.lang.annotation.*;
import java.time.Duration;

@Configuration
public class WebDriverFactory {

    @Value("${run.platform:chrome}")
    private String platform;

    @Value("${run.headless:false}")
    private String headless;

    @Value("${driver.path}")
    private String relativeDriverPath;

    @Value("${wait.timeout:5}")
    private String waitTimeOut;

    @Bean
    @Scope("webdriverscope")
    //@ConditionalOnProperty(name = "run.platform", havingValue = "chrome")
    @Profile("chrome")
    public WebDriver setupChromeDriver(){
        String absoluteWebdriverPath = System.getProperty("user.dir") + relativeDriverPath;
        System.setProperty("webdriver.chrome.driver", absoluteWebdriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless.equalsIgnoreCase("TRUE")){
            chromeOptions.addArguments("--headless");
        }

        return new ChromeDriver(chromeOptions);
    }

    @Bean
    @Scope("webdriverscope")
    //@ConditionalOnProperty(name = "run.platform", havingValue = "msedge")
    @Profile("msedge")
    public WebDriver setupMSEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver webDriver){
        return new WebDriverWait(webDriver, Duration.ofSeconds(Integer.parseInt(waitTimeOut)));
    }
}
