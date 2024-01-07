package com.tientd0802.CucumberAF.contexthook;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.IOException;

public class Hooks {

    @Autowired
    WebDriver webDriver;

    @SneakyThrows
    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(source);
            scenario.attach(fileContent,"image/png","screenshot");
        }
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
